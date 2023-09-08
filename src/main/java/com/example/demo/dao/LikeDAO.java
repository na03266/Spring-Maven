package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeDAO {
    int selectLikeCount(@Param("contentType") String contentType,
                        @Param("contentNo") int contentNo);

    void insertLike(String contentType, int contentNo);

    void deleteLike(String contentType, int contentNo);

    int increaseLikeCount(String contentType, int contentNo);
}
