package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    //로그인 페이지

    //회원 등록 페이지
    @GetMapping("/users/join")
    public String joinPage(){
        return "join";
    }

    //회원 등록 처리

    // 회원 정보 수정 페이지

    // 정보 수정 처리
}
