package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleNotValidException(Model model, MethodArgumentNotValidException ex) {
        if (ex.getFieldError() != null) {
            model.addAttribute("message", ex.getFieldError().getDefaultMessage());
        }

        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e) {
        model.addAttribute("message", e.getMessage());

        return "error";
    }
}
