package com.example.demospringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Cấu hình đường dẫn truy cập
        String[] resourcesPublic = new String[]{
                "/phim-le", "/phim-le", "/phim-chieu-rap", "/tin-tuc/**"
        };
        http.authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/").permitAll();
                    authorizeRequests.requestMatchers("/user").hasRole("USER");
                    authorizeRequests.requestMatchers("/admin").hasRole("ADMIN");

                    authorizeRequests.requestMatchers("/css/**", "/js/**", "/image/**").permitAll();
                    authorizeRequests.requestMatchers(resourcesPublic).permitAll();
                    authorizeRequests.requestMatchers("/author").hasAnyRole("ADMIN", "AUTHOR");
                    authorizeRequests.requestMatchers("GET", "/aa/**", "/bb/**").hasRole("ADMIN");
                    authorizeRequests.requestMatchers("/abc", "/bcd").hasAuthority("ROLE_USER");
                    authorizeRequests.requestMatchers("/xxx", "/yyy").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
                    authorizeRequests.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập
                }
        );

        // Cấu hình form login
        http.formLogin(formLogin -> {
            formLogin.defaultSuccessUrl("/", true); // Nếu đăng nhập thành công thì chuyển hướng về trang chủ
            formLogin.permitAll(); // Cho phép tất cả mọi người truy cập vào form login mà không cần xác thực
        });

        // Cấu hình logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/"); // Nếu logout thành công thì chuyển hướng về trang chủ
            logout.deleteCookies("JSESSIONID"); // Xóa cookie
            logout.invalidateHttpSession(true); // Hủy session
            logout.clearAuthentication(true); // Xóa thông tin đăng nhập của user hiện tại trong SecurityContext
            logout.permitAll(); // Cho phép tất cả mọi người truy cập vào logout mà không cần xác thực
        });

        return http.build();
    }
}
