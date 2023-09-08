package com.example.demo.controller;

import com.example.demo.model.LikeModel;
import com.example.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeApiController {

    @Autowired
    private LikeService likeService;

    @PutMapping("/api/likes/comment/{commentNo}")
    public LikeModel increaseCommentLikeCount(@PathVariable int commentNo) {
        return new LikeModel("COMMENT", commentNo, likeService.increaseCommentLikeCount(commentNo));
    }
}
