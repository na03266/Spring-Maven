package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 댓글의 CRUD를 처리하는 API
@RestController // 자동으로 responsebody 애너테이션이 붙은것과 같이 반응함
public class CommentApiComtroller {

    @Autowired
    private CommentService commentService;

    //댓글 조회 API
    @GetMapping("/api/comment/{no}")
    public CommentModel getComment(@PathVariable int no) { //주소에 있는 변수를 가져오는 애너테이션

        CommentModel comment = commentService.getComment(no);

        return comment;
    }

    //댓글 등록 API
    @PostMapping("/api/comments")
    public CommentModel postComment(@RequestBody CommentModel comment) {

        //등록 처리
        return commentService.createComment(comment);
    }

//@ RequestParam 외부에서 들어오는 값(?hello=hi)을 그대로 출력(hi)

    //댓글 수정 API
    @PutMapping("/api/comment/{no}")
    public CommentModel modifyComment(@RequestBody CommentModel comment, @PathVariable int no) {
        comment.setNo(no);
        return commentService.updateComment(comment);
    }

    //댓글 삭제 API
    @DeleteMapping("/api/comment/{no}")
    public String deleteComment(@PathVariable int no){
        commentService.deleteComment(no);
        return "OK";
    }
}
