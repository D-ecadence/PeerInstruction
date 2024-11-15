package com.zch1001.pi.controller;

import com.zch1001.pi.model.LoginRequest;
import com.zch1001.pi.model.LoginResponse;
import com.zch1001.pi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {
    private AuthService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.queryUser(request);
    }

}
