package vn.techmaster.movie.config;

import com.github.slugify.Slugify;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Slugify slugify() {
        return Slugify.builder()
                .customReplacement("đ", "d")
                .customReplacement("Đ", "D")
                .build();
    }
}
