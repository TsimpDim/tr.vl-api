package com.trvl.core.controller;

import com.trvl.core.dto.LogInRequestDTO;
import com.trvl.core.dto.SignUpRequestDTO;
import com.trvl.core.model.Token;
import com.trvl.core.service.AuthService;
import com.trvl.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;

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

    @PostMapping(value = "login", produces = "application/json")
    @ResponseBody
    public ResponseEntity<HashMap> login(@Valid @RequestBody LogInRequestDTO loginRequestDTO) {
        String token = authService.loginUser(loginRequestDTO);
        HashMap<String, String> respData = new HashMap<>();
        respData.put("token", token);
        respData.put("username", loginRequestDTO.getUsername());


        return ResponseEntity.status(HttpStatus.OK)
                .header("bearer", token)
                .body(respData);
    }
}
