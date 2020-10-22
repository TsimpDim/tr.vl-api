package com.trvl.core.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequestDTO {

    @Email
    private String email;

    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "password required")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}