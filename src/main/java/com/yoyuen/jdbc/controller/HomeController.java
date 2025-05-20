package com.yoyuen.jdbc.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/wangtaile")
    public String user(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            // 用户未认证，重定向到登录页面
            return "redirect:/login";
        }
        model.addAttribute("username", principal.getAttribute("login"));
        model.addAttribute("email", principal.getAttribute("email"));
        return "user";
    }

    @GetMapping("/debug")
    public String debugUser(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            model.addAttribute("error", "未认证，请先登录");
            return "debug"; // 显示错误信息
        }
        model.addAttribute("attributes", principal.getAttributes());
        return "debug";
    }
}
