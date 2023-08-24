package com.example.demo.controller;

import com.example.demo.dao.CommentJdbcDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private CommentJdbcDAO commentJdbcDAO;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {

        List<Map<String, ?>> commentList = commentJdbcDAO.selectAllCommentList();

        model.addAttribute("commentList", commentList); //댓글 리스트를 view로 전달한다.

        return "main";
    }
}
