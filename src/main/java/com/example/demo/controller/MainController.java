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
    @PostMapping("/comments")
    public String createComment(CommentModel commentModel){

        System.out.println(commentModel.getAuthor());
        System.out.println(commentModel.getComment());

        commentDAO.insertComment(commentModel);
        return "redirect:/";
    }

    @DeleteMapping("/comments/{no}")
    public String deleteComment(@PathVariable int no){

        commentDAO.deleteComment(no);

        return "redirect:/";
    }
}
