package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {
    private int no;
    @JsonIgnore //리스폰스 바디로 호출했을때 api가 내려가면 안되는건 이렇게 씀
    private String author;
    private String comment;
    private LocalDateTime date;
}
