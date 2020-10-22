package com.trvl.core.service;

import com.trvl.core.dto.SignUpRequestDTO;
import com.trvl.core.exception.UserAlreadyExistsException;
import com.trvl.core.model.User;
import com.trvl.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public AuthService(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void signUpUser(SignUpRequestDTO signUpRequest) {
        Optional<User> userExist = userRepository.findByUsername(signUpRequest.getUsername());
        if (userExist.isPresent())
            throw new UserAlreadyExistsException();

        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
    }
}
