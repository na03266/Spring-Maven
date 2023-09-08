package com.example.demo.service;

import com.example.demo.dao.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeDAO likeDAO;

    public int increaseCommentLikeCount(int commentNo) {
        likeDAO.increaseLikeCount("COMMENT" , commentNo);
        return likeDAO.selectLikeCount("COMMENT", commentNo);
    }
}
