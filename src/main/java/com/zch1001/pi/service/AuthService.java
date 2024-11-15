package com.zch1001.pi.service;

import com.zch1001.pi.entity.Admin;
import com.zch1001.pi.entity.Student;
import com.zch1001.pi.entity.Teacher;
import com.zch1001.pi.model.RegisterRequest;
import com.zch1001.pi.model.RegisterResponse;
import com.zch1001.pi.repository.AdminRepository;
import com.zch1001.pi.repository.StudentRepository;
import com.zch1001.pi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zch1001.pi.model.LoginRequest;
import com.zch1001.pi.model.LoginResponse;

@Service
public class AuthService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AdminRepository adminRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        int role = loginRequest.getRole();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        LoginResponse loginResponse = new LoginResponse();
        if (role == 1) {
            Admin admin = adminRepository.findByEmail(email);
            if (admin == null) {
                loginResponse.setCode(-1);
                loginResponse.setMsg("Error!");
                loginResponse.setData(null);
            }
            else {
                loginResponse.setCode(0);
                loginResponse.setMsg("Login success!");
                LoginResponse.UserData userData = new LoginResponse.UserData();
                userData.setUserId(admin.getId());
                userData.setUserName(admin.getName());
                userData.setUserAvatar(admin.getAvatar());
                userData.setToken("");
                loginResponse.setData(userData);
            }
        }
        else if (role == 2) {
            Teacher teacher = teacherRepository.findByEmail(email);
            if (teacher == null) {
                loginResponse.setCode(-1);
                loginResponse.setMsg("Error!");
                loginResponse.setData(null);
            }
            else {
                loginResponse.setCode(0);
                loginResponse.setMsg("Login success!");
                LoginResponse.UserData userData = new LoginResponse.UserData();
                userData.setUserId(teacher.getId());
                userData.setUserName(teacher.getName());
                userData.setUserAvatar(teacher.getAvatar());
                userData.setToken("");
                loginResponse.setData(userData);
            }
        }
        else if (role == 3) {
            Student student = studentRepository.findByEmail(email);
            if (student == null) {
                loginResponse.setCode(-1);
                loginResponse.setMsg("Error!");
                loginResponse.setData(null);
            }
            else {
                loginResponse.setCode(0);
                loginResponse.setMsg("Login success!");
                LoginResponse.UserData userData = new LoginResponse.UserData();
                userData.setUserId(student.getId());
                userData.setUserName(student.getName());
                userData.setUserAvatar(student.getAvatar());
                userData.setToken("");
                loginResponse.setData(userData);
            }
        }
        return loginResponse;
    }

     public RegisterResponse register(RegisterRequest registerRequest) {
         int verificationCode = registerRequest.getVerificationCode();
         int role = registerRequest.getRole();
         String email = registerRequest.getEmail();
         String password = registerRequest.getPassword();
         RegisterResponse registerResponse = new RegisterResponse();
         if (role == 2) {
             Teacher teacher = new Teacher();
             teacher.setEmail(email);
             teacherRepository.save(teacher);
             registerResponse.setCode(0);
             registerResponse.setMsg("Register success!");
             RegisterResponse.UserData userData = new RegisterResponse.UserData();
             userData.setUserId(teacher.getId());
             userData.setUserName(teacher.getName());
             userData.setUserAvatar(teacher.getAvatar());
             userData.setToken("");
             registerResponse.setData(userData);
         }
         else if (role == 3) {
             Student student = new Student();
             student.setEmail(email);
             studentRepository.save(student);
             registerResponse.setCode(0);
             registerResponse.setMsg("Register success!");
             RegisterResponse.UserData userData = new RegisterResponse.UserData();
             userData.setUserId(student.getId());
             userData.setUserName(student.getName());
             userData.setUserAvatar(student.getAvatar());
             userData.setToken("");
             registerResponse.setData(userData);
         }
         return registerResponse;
     }
}
