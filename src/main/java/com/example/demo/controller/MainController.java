package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    restcontroller로 되어있으면 리턴값이 자동으로 출력되게 된다. 그래서 일반 컨트롤러로 바꿔줘야한다.
 */
@Controller
public class MainController {

    @GetMapping
    public String mainPage(){
        return "redirect:/comment";
    }


}
