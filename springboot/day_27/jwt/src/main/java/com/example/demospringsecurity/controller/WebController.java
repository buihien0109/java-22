package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.security.IsAdmin;
import com.example.demospringsecurity.security.IsUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebController {
    @GetMapping("/") // ai cũng có thể truy cập
    public String getHome() {
        return "index";
    }

    @IsUser
    @GetMapping("/user") // chỉ có role USER mới có thể truy cập
    public String getUser() {
        return "user";
    }

    @IsAdmin
    @GetMapping("/admin") // chỉ có role ADMIN mới có thể truy cập
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
