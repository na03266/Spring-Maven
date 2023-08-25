package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    restcontroller로 되어있으면 리턴값이 자동으로 출력되게 된다. 그래서 일반 컨트롤러로 바꿔줘야한다.
 */
@Controller
public class MainController {

    @Autowired
    private CommentDAO commentDAO;

    /*
        메인 페이지 - 댓글 목록 표시
     */
    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        List<CommentModel> cmList = commentDAO.selectAllCommentList();

        model.addAttribute("commentList", cmList); //댓글 리스트를 view로 전달한다.

        return "main"; //뷰의 위치! getmapping일때만!
    }

    // 댓글 등록 처리
    @PostMapping("/comments")
    public String createComment(CommentModel commentModel){

        System.out.println(commentModel.getAuthor());
        System.out.println(commentModel.getComment());

        commentDAO.insertComment(commentModel);
        return "redirect:/";
    }

    //댓글 삭제 처리
    @DeleteMapping("/comments/{no}")
    public String deleteComment(@PathVariable int no){

        commentDAO.deleteComment(no);

        return "redirect:/";
    }

    @GetMapping("/comments/{no}")//화면은 겟매핑
    public String modifyCommentForm(@PathVariable int no, Model model){

        CommentModel comment = commentDAO.selectComment(no);
        model.addAttribute("comment", comment);

        return "comment-form";
    }

    @GetMapping("/comment/{no}") //원래는  putmapping을 써야하지만, html만 사용할 경우에는 post와 get메소드만 사용함
    public String modifyComment(@PathVariable int no, CommentModel commentModel){

        //댓글 정보 update 처리
        commentModel.setNo(no);
        commentDAO.updateComment(commentModel);

        return "redirect:/";
    }
}
