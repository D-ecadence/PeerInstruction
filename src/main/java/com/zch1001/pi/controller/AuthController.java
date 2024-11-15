package com.zch1001.pi.controller;

import com.zch1001.pi.model.*;
import com.zch1001.pi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/email_verify")
    public EmailVerifyResponse emailVerify(@RequestBody EmailVerifyRequest emailVerifyRequest) {
        return authService.emailVerify(emailVerifyRequest);
    }

    @PostMapping("/modify_password")
    public ModifyPasswordResponse emailVerify(@RequestBody ModifyPasswordRequest modifyPasswordRequest) {
        return authService.modifyPassword(modifyPasswordRequest);
    }
}
