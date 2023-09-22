package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 목록 화면
    @GetMapping("/comments")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String getComments(Model model, CommentModel commentModel) {
        // 로그인 유저 정보를 구하는 첫번째 방법 https://github.com/ttaengz/spring-study/blob/main/docs/08%20%EC%9D%B8%EC%A6%9D%20(Spring%20Security)%20-%202%EB%B6%80.md#securitycontextholder%EC%97%90%EC%84%9C-%EA%BA%BC%EB%82%B4%EC%98%A4%EA%B8%B0
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(!StringUtils.equals("anonymousUser", principal)) {
//            System.out.println(principal.toString());
//            //model.addAttribute("userName", ((User) principal).getUsername());
//        }

        List<CommentModel> cmList = commentService.getAllCommentList();
        model.addAttribute("commentList", cmList); // 댓글 리스트를 View로 전달한다.

        return "main";
    }

    // 댓글 등록 처리
    @PostMapping("/comments")
    public String createComment(@Valid CommentModel commentModel, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("errMessage", bindingResult.getFieldError().getDefaultMessage());
            return getComments(model, commentModel);
        } else {
            if (principal != null) {
                commentModel.setUserId(principal.getName());
            }
            commentService.createComment(commentModel);
        }

        return "redirect:/";
    }

    // 댓글 수정 화면 요청 처리
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN')")
    @GetMapping("/comments/{no}")
    public String modifyCommentForm(@PathVariable int no, Model model) throws Exception {
//        System.out.println("로그인한 사용자: " + Optional.ofNullable(principal).map(Principal::getName).orElse("로그인안함"));

        CommentModel comment = commentService.getComment(no);
        model.addAttribute("comment", comment);

//        if (!StringUtils.equals(comment.getUserId(),  principal.getName())) {
//            throw new Exception("수정 권한이 없습니다.");
//        }

        return "comment-form";
    }

    // 댓글 수정 요청 처리
    @PostMapping("/comments/{no}")
    public String modifyComment(@PathVariable int no, @Valid CommentModel commentModel) {
        // 댓글 정보 update 처리
        commentModel.setNo(no);
        commentService.updateComment(commentModel);

        return "redirect:/";
    }
}
