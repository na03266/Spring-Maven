package com.example.demo.service;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//데이터베이스에서 불러오는 객체의 수정이나 자료형의 변경등의 기능을 수행함
@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    //덧글 조회
    public CommentModel getComment(int no){
        return commentDAO.selectComment(no);
    }

    //모든 댓글 목록
    public List<CommentModel> getAllCommentList(){
        return commentDAO.selectAllCommentList();
    }

    // 댓글 등록
    public void createComment(CommentModel commentModel) {
        commentDAO.insertComment(commentModel);
    }

    //덧글 수정
    public void updateComment(CommentModel commentModel) {
        commentDAO.updateComment(commentModel);
    }

    //덧글 삭제
    public void deleteComment(int no) {
        commentDAO.deleteComment(no);
    }
}
