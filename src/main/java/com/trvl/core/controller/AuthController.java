package com.trvl.core.controller;

import com.trvl.core.dto.SignUpRequestDTO;
import com.trvl.core.service.AuthService;
import com.trvl.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AuthController {
    private UserService userService;
    private AuthService authService;

    @Autowired
    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequestDTO signupRequestDTO) {
        authService.signUpUser(signupRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
