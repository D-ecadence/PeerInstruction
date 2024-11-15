package com.zch1001.pi.controller;

import com.zch1001.pi.model.LoginRequest;
import com.zch1001.pi.model.LoginResponse;
import com.zch1001.pi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.queryUser(request);
    }
}
