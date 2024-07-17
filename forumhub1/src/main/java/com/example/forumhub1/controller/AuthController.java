package com.example.forumhub1.controller;

import com.example.forumhub1.model.AuthenticationRequest;
import com.example.forumhub1.model.AuthenticationResponse;
import com.example.forumhub1.model.User;
import com.example.forumhub1.model.UserRegistrationRequest;
import com.example.forumhub1.model.RegistrationResponse;
import com.example.forumhub1.repository.UserRepository;
import com.example.forumhub1.service.MyUserDetailsService;
import com.example.forumhub1.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public RegistrationResponse registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUsername(userRegistrationRequest.getUsername());
        user.setPassword(userDetailsService.encodePassword(userRegistrationRequest.getPassword())); // Encoding password
        user.setEmail(userRegistrationRequest.getEmail());
        user.setRole(userRegistrationRequest.getRole());
        userRepository.save(user);

        return new RegistrationResponse("User registered successfully", user.getUsername(), user.getEmail(), user.getRole());
    }

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }
}
