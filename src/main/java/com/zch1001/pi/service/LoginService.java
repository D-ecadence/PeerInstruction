package com.zch1001.pi.service;

import org.springframework.stereotype.Service;
import com.zch1001.pi.model.LoginRequest;
import com.zch1001.pi.model.LoginResponse;

@Service
public class LoginService {
    public LoginResponse queryUser(LoginRequest request) {
        // 假设有一个数据库验证过程，实际应用中会去数据库查找用户数据
        int role = request.getRole();
        String email = request.getEmail();
        String password = request.getPassword();

        return correctId.equals(request.getId()) &&
                correctPassword.equals(request.getPassword()) &&
                correctRole == request.getRole();
    }
}
