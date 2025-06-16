package com.testjune.june.Controller;


import com.testjune.june.Service.userService;
import com.testjune.june.dao.entity.User;
import com.testjune.june.dto.response.userResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    userService userService;

    @GetMapping
    public List<userResponse> getAllUsers() {
        log.info("get all users");
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<userResponse> getUserById(@PathVariable Long id) {
        log.info("get user by id: {}", id);
        return userService.getUserById(id);
    }

}