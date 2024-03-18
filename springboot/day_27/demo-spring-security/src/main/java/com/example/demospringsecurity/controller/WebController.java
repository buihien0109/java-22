package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.security.IAuthenticationFacade;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class WebController {
    private final IAuthenticationFacade authenticationFacade;

    @GetMapping("/") // ai cũng có thể truy cập
    public String getHome() {
        return "Home Page";
    }

    @GetMapping("/user") // chỉ có role USER mới có thể truy cập
    public String getUser() {
        return "User Page";
    }

    @GetMapping("/admin") // chỉ có role ADMIN mới có thể truy cập
    public String getAdmin() {
        return "Admin Page";
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("/info2")
    public ResponseEntity<?> getInfo2(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/info3")
    public ResponseEntity<?> getInfo3(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("/info4")
    public ResponseEntity<?> getInfo4(HttpServletRequest request) {
        return ResponseEntity.ok(request.getUserPrincipal());
    }

    @GetMapping("/info5")
    public ResponseEntity<?> getInfo5() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return ResponseEntity.ok(authentication);
    }
}
