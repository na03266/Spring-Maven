package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //로그인 페이지

    //회원 등록 페이지
    @GetMapping("/users/join")
    public String joinPage(){
        return "join";
    }

    //회원 등록 처리
    @PostMapping(value = "/users")
    public String postUser(@Valid UserModel user, Model model){
        try {
            userService.insertUser(user);
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("user", user);
            model.addAttribute("errMessage", "이미 사용중인 사용자 ID입니다.");
            return "join_form";
        }

        return "redirect:/";
    }

    // 회원 정보 수정 페이지

    // 정보 수정 처리
}
