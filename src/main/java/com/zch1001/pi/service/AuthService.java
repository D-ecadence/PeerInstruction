package com.zch1001.pi.service;

import com.zch1001.pi.entity.Admin;
import com.zch1001.pi.entity.Student;
import com.zch1001.pi.entity.Teacher;
import com.zch1001.pi.repository.AdminRepository;
import com.zch1001.pi.repository.StudentRepository;
import com.zch1001.pi.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import com.zch1001.pi.model.LoginRequest;
import com.zch1001.pi.model.LoginResponse;

@Service
public class AuthService {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private AdminRepository adminRepository;
    public LoginResponse queryUser(LoginRequest request) {
        int role = request.getRole();
        String email = request.getEmail();
        String password = request.getPassword();
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
}
