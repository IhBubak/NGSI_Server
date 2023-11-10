package com.NGSI.Server.NGSIServer.controller;

import com.NGSI.Server.NGSIServer.dto.LoginRequest;
import com.NGSI.Server.NGSIServer.dto.LoginResponse;
import com.NGSI.Server.NGSIServer.dto.RegisterRequest;
import com.NGSI.Server.NGSIServer.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service;

//    @PostMapping("/register")
//    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(service.register(request));
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
