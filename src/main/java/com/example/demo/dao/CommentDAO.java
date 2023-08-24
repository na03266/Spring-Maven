package com.example.demo.dao;

import com.example.demo.model.CommentModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    List<CommentModel> selectAllCommentList();
}
