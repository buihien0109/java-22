package com.example.demospringsecurity.service;

import com.example.demospringsecurity.entity.Role;
import com.example.demospringsecurity.entity.TokenConfirm;
import com.example.demospringsecurity.entity.User;
import com.example.demospringsecurity.model.enums.TokenType;
import com.example.demospringsecurity.model.request.LoginRequest;
import com.example.demospringsecurity.model.request.RegisterRequest;
import com.example.demospringsecurity.model.response.VerifyAccountResponse;
import com.example.demospringsecurity.repository.RoleRepository;
import com.example.demospringsecurity.repository.TokenConfirmRepository;
import com.example.demospringsecurity.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final HttpSession session;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenConfirmRepository tokenConfirmRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public void login(LoginRequest request) {
        // Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        try {
            // Tiến hành xác thực
            Authentication authentication = authenticationManager.authenticate(token);

            // Lưu đối tượng đã xác thực vào trong SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Lưu vào trong session
            session.setAttribute("MY_SESSION", authentication.getName()); // Lưu email -> session
        } catch (DisabledException e) {
            throw new RuntimeException("Tài khoản chưa được xác thực");
        } catch (AuthenticationException e) {
            throw new RuntimeException("Email hoặc mật khẩu không đúng");
        }
    }

    @Transactional
    public String register(RegisterRequest request) {
        // Kiểm tra email đã tồn tại chưa
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại");
        }

        // Lưu user vào database
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy role USER"));
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(userRole))
                .enabled(false)
                .build();
        userRepository.save(user);

        // Lưu token vào database
        TokenConfirm tokenConfirm = TokenConfirm.builder()
                .token(UUID.randomUUID().toString())
                .tokenType(TokenType.REGISTRATION)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusHours(1))
                .user(user)
                .build();
        tokenConfirmRepository.save(tokenConfirm);

        // Trả về path xác thực tài khoản
        // TODO: Link này gửi vào trong email
        String link = "http://localhost:8080/xac-thuc-tai-khoan?token=" + tokenConfirm.getToken();
        mailService.sendMail(user.getEmail(), "Xác thực tài khoản", link);
        return "Đăng ký thành công, vui lòng kiểm tra email để xác thực tài khoản";
    }

    @Transactional
    public VerifyAccountResponse verifyAccount(String token) {
        // Tìm kiếm token trong database
        Optional<TokenConfirm> optionalTokenConfirm = tokenConfirmRepository
                .findByTokenAndTokenType(token, TokenType.REGISTRATION);

        // Kiểm tra token có tồn tại không
        if(optionalTokenConfirm.isEmpty()) {
            return VerifyAccountResponse.builder()
                    .success(false)
                    .message("Token không hợp lệ")
                    .build();
        }

        // Kiểm tra xem token đã được xác thực chưa
        TokenConfirm tokenConfirm = optionalTokenConfirm.get();
        if(tokenConfirm.getConfirmedAt() != null) {
            return VerifyAccountResponse.builder()
                    .success(false)
                    .message("Token đã được xác thực")
                    .build();
        }

        // Kiểm tra xem token đã hết hạn chưa
        if(tokenConfirm.getExpiredAt().isBefore(LocalDateTime.now())) {
            return VerifyAccountResponse.builder()
                    .success(false)
                    .message("Token đã hết hạn")
                    .build();
        }

        // Xác thực tài khoản của user
        User user = tokenConfirm.getUser();
        user.setEnabled(true);
        userRepository.save(user);

        // Cập nhật thời gian xác thực token
        tokenConfirm.setConfirmedAt(LocalDateTime.now());
        tokenConfirmRepository.save(tokenConfirm);

        return VerifyAccountResponse.builder()
                .success(true)
                .message("Xác thực tài khoản thành công")
                .build();
    }
}
