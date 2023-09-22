package com.example.demo.service;

import com.example.demo.dao.CommentDAO;
import com.example.demo.dao.LikeDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

//데이터베이스에서 불러오는 객체의 수정이나 자료형의 변경등의 기능을 수행함
@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private LikeDAO likeDAO;

    // 댓글 조회
    @PostAuthorize("hasRole('ROLE_USER') and (returnObject.userId == principal.username)")
    public CommentModel getComment(int no) {
        CommentModel comment = commentDAO.selectComment(no);
        comment.setLikeCount(likeDAO.selectLikeCount("COMMENT", comment.getNo()));
        return comment;
    }

    // 모든 댓글 목록
    public List<CommentModel> getAllCommentList() {
        return commentDAO.selectAllComment();

    }

    // 댓글 등록

    public CommentModel createComment(CommentModel commentModel) {
        commentDAO.insertComment(commentModel);
        likeDAO.insertLike("COMMENT", commentModel.getNo());
        return getComment(commentModel.getNo());
    }

    // 댓글 수정
    public CommentModel updateComment(CommentModel commentModel) {
        commentDAO.updateComment(commentModel);
        return getComment(commentModel.getNo());
    }

    // 댓글 삭제
    public void deleteComment(int no) {
        commentDAO.deleteComment(no);
        likeDAO.deleteLike("COMMENT", no);
    }
}
