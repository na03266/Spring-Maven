package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {
    private int no;
    //@JsonIgnore //리스폰스 바디로 호출했을때 api가 내려가면 안되는건 이렇게 씀

    private String author;
    private String comment;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm") // 시간의 자료형을 수정해서 전송
    private LocalDateTime date;
    //@Deprecated 삭제될 예정임을 알려주는 애너테이션
}
