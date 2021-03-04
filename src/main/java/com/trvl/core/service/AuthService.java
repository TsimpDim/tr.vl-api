package com.trvl.core.service;

import com.trvl.core.dto.LogInRequestDTO;
import com.trvl.core.dto.SignUpRequestDTO;
import com.trvl.core.exception.UserAlreadyExistsException;
import com.trvl.core.model.Token;
import com.trvl.core.model.User;
import com.trvl.core.repository.TokenRepository;
import com.trvl.core.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private TokenRepository tokenRepository;

    @Autowired
    public AuthService(
            BCryptPasswordEncoder passwordEncoder,
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            TokenRepository tokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenRepository = tokenRepository;
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

    public String loginUser(LogInRequestDTO loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = generateSession(getCurrentUser());
        return token;
    }

    public User getCurrentUser(){
         User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         return principal;
    }


    public String generateSession(User user) {
        Token token = tokenRepository.save(new Token(new RandomString(70).nextString(), user));
        return token.getToken();
    }
}
