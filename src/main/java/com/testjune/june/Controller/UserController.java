package com.testjune.june.Controller;

import com.testjune.june.Service.userService;
import com.testjune.june.dao.entity.User;
import com.testjune.june.dto.request.UserRequest;
import com.testjune.june.dto.response.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {

    private final userService userService;

    @Autowired
    public UserController(userService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public String ping() {
        return "fetching User";
    }

    // POST /users  --> create a new user
    @PostMapping("/users")
    public ResponseEntity<userResponse> createUser(@RequestBody UserRequest userRequest) {
        User savedUser = userService.saveUser(userRequest);

        userResponse response = new userResponse();
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());

        return ResponseEntity.ok(response);
    }

    // GET /users/{id} --> get user by id
    @GetMapping("/{id}")
    public ResponseEntity<userResponse> getUserById(@PathVariable Long id) {
        Optional<User> userOpt = userService.getUserById(id);

        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        userResponse response = new userResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());

        return ResponseEntity.ok(response);
    }

}