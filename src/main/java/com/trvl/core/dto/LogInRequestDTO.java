package com.trvl.core.dto;

import javax.validation.constraints.NotBlank;

public class LogInRequestDTO {

    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "password required")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}