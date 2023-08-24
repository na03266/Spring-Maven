package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.dao.CommentJdbcDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CommentJdbcDAO commentJdbcDAO;

    @Autowired
    private CommentDAO commentDAO;

    /*
        메인 페이지 - 댓글 목록 표시
     */
    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {

        //List<Map<String, ?>> commentList = commentJdbcDAO.selectAllCommentList();

        List<CommentModel> cmList = commentDAO.selectAllCommentList();

        model.addAttribute("commentList", cmList); //댓글 리스트를 view로 전달한다.

        return "main";
    }
}
