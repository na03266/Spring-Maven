package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    //댓글의 목록 표시
    @GetMapping("/comments")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        List<CommentModel> cmList = commentService.getAllCommentList();

        model.addAttribute("commentList", cmList); //댓글 리스트를 view로 전달한다.

        return "main"; //뷰의 위치! getmapping일때만!
    }

    // 댓글 등록 처리
    @PostMapping("/comments")
    public String createComment(CommentModel commentModel ) {

        System.out.println(commentModel.getAuthor());
        System.out.println(commentModel.getComment());

        commentService.createComment(commentModel);
        return "redirect:/";
    }

    //에러 처리기
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleError(Model model, MethodArgumentNotValidException ex){

        Optional.ofNullable(ex.getFieldError()).map(FieldError::getDefaultMessage).orElse("");
        model.addAttribute("message", ex.getFieldError().getDefaultMessage());
        return "error";
    }

    //댓글 수정 화면 요청 처리
    @GetMapping("/comments/{no}")//화면은 겟매핑
    public String modifyCommentForm(@PathVariable int no, Model model) {

        CommentModel comment = commentService.getComment(no);
        model.addAttribute("comment", comment);

        return "comment-form";
    }

    //댓글 수정 요청 처리
    @GetMapping("/comment/{no}") //원래는  putmapping을 써야하지만, html만 사용할 경우에는 post와 get메소드만 사용함
    public String modifyComment(@PathVariable int no, CommentModel commentModel) {

        //댓글 정보 update 처리
        commentModel.setNo(no);
        commentService.updateComment(commentModel);

        return "redirect:/";
    }
}
