package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeModel {
    private String contentType;
    private int contentNo;
    private int count;
}
