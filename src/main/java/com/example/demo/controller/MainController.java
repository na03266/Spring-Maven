package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
    restcontroller로 되어있으면 리턴값이 자동으로 출력되게 된다. 그래서 일반 컨트롤러로 바꿔줘야한다.
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        return "redirect:/comments";
    }

    // MainController (또는 ErrorController)
    @GetMapping("/errors/access-denied")
    public String accessDeniedPage(Model model) {
        model.addAttribute("message", "요청 페이지에 접근할 권한이 없습니다.");
        return "error";
    }

    @PreAuthorize("denyAll()")
    @GetMapping("/test")
    public String empty() {
        return "pure";
    }
}
