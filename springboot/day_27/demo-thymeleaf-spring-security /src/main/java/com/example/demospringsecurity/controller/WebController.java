package com.example.demospringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {
    @GetMapping("/") // ai cũng có thể truy cập
    public String getHome() {
        return "index";
    }

    @GetMapping("/user") // chỉ có role USER mới có thể truy cập
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin") // chỉ có role ADMIN mới có thể truy cập
    public String getAdmin() {
        return "admin";
    }
}
