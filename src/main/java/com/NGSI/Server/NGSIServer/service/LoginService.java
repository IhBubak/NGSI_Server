package com.NGSI.Server.NGSIServer.service;

import com.NGSI.Server.NGSIServer.config.JwtService;
import com.NGSI.Server.NGSIServer.dto.LoginRequest;
import com.NGSI.Server.NGSIServer.dto.LoginResponse;
import com.NGSI.Server.NGSIServer.dto.RegisterRequest;
import com.NGSI.Server.NGSIServer.model.User;
import com.NGSI.Server.NGSIServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

//    public LoginResponse register(RegisterRequest request) {
//        var user = User.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .build();
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return LoginResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

    public LoginResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return LoginResponse.builder()
                .token(jwtToken)
                .build();
    }
}
