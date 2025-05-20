package com.yoyuen.jdbc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        // 放行 OAuth2 回调路径和静态资源
                        .requestMatchers("/login", "/favicon.ico", "/static/**", "/login/oauth2/code/**").permitAll()
                        // 其他路径需要认证
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/wangtaile", true) // 登录成功后跳转
                        .failureHandler((request, response, exception) -> {
                            // 记录失败原因（如回调 URL 错误、权限不足）
                            System.err.println("OAuth2 登录失败：" + exception.getMessage());
                            response.sendRedirect("/login?error");
                        })
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );
        return http.build();
    }
}
