package com.example.demo.service;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    public CommentModel getComment(int no){
        return commentDAO.selectComment(no);
    }
}
