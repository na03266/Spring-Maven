package com.example.demo.model;

import com.example.demo.validator.Author;
import com.example.demo.validator.PreventFuxx;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {
    private int no;
    //@JsonIgnore //리스폰스 바디로 호출했을때 api가 내려가면 안되는건 이렇게 씀

    @NotBlank(message = "작성자 항목은 필수입니다.")
    @Size(min = 2, max = 10, message = "작성자는 {min}자~{max}자 이내이어야 합니다.")
    @Pattern(regexp = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]*$", message = "작성자는 영문 대소문자 및 한글만 가능합니다.")
    @Author
    private String author;

    @NotBlank(message = "댓글 내용은 필수 항목입니다.")
    @PreventFuxx
    private String comment;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm") // 시간의 자료형을 수정해서 전송
    private String userId;

    private LocalDateTime modDatetime;
    private LocalDateTime regDatetime;
    private int likeCount;

    @Deprecated
    public LocalDateTime getDate() {
        return regDatetime;
    }
    //@Deprecated 삭제될 예정임을 알려주는 애너테이션
}
