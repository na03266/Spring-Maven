package com.example.demo.dao;

import com.example.demo.model.CommentModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDAO {
    CommentModel selectAllComment();
}
