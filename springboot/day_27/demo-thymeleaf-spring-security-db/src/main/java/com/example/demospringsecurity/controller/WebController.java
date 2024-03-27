package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.security.IsAdmin;
import com.example.demospringsecurity.security.IsUser;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {
    @GetMapping("/") // ai cũng có thể truy cập
    public String getHome() {
        return "index";
    }

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_USER')")
    @IsUser
    @GetMapping("/user") // chỉ có role USER mới có thể truy cập
    public String getUser() {
        return "user";
    }

//    @RolesAllowed("ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
