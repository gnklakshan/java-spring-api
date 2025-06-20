package com.testjune.june.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class UserRequest {
    @NotEmpty(message = "Username is required")
    private String username;

    private String firstName;
    private String lastName;
}