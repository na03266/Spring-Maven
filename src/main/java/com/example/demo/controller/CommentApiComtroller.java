package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 댓글의 CRUD를 처리하는 API
@RestController // 자동으로 responsebody 애너테이션이 붙은것과 같이 반응함
public class CommentApiComtroller {

    @Autowired
    private CommentService commentService;

    @GetMapping("/api/comment/{no}")
    public CommentModel getComment(@PathVariable int no){ //주소에 있는 변수를 가져오는 애너테이션

        CommentModel comment = commentService.getComment(no);

        return comment;
    }
}
