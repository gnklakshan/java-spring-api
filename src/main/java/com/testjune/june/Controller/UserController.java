package com.testjune.june.Controller;


import com.testjune.june.Service.userService;
import com.testjune.june.dao.entity.User;
import com.testjune.june.dto.request.UserRequest;
import com.testjune.june.dto.response.userResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@AllArgsConstructor
@Slf4j
public class UserController {
    userService userService;

    @GetMapping("/users")
    public List<userResponse> getAllUsers() {
        log.info("get all users");
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<userResponse> getUserById(@PathVariable Long id) {
        log.info("get user by id: {}", id);
        return userService.getUserById(id);
    }

    @PostMapping("/new-user")
    public ResponseEntity<String> createUser( @RequestBody UserRequest user) {
        log.info("create user: {}", user);
        String userId = userService.newUser(user);
        return ResponseEntity.ok(userId);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest user) {
        log.info("update user: {}", id);
        String userId = userService.updateUser(id, user).getId().toString();
        return ResponseEntity.ok(userId) ;
    }

}