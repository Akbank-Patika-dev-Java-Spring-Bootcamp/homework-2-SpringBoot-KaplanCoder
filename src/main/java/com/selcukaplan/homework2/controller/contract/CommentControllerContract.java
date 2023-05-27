package com.selcukaplan.homework2.controller.contract;

import com.selcukaplan.homework2.dto.comment.CommentDTO;
import com.selcukaplan.homework2.dto.comment.CommentSaveRequest;

import java.util.List;

public interface CommentControllerContract {

    List<CommentDTO> getCommentsOfUser(Long userId);

    List<CommentDTO> getCommentsOfProduct(Long productId);

    CommentDTO saveComment(CommentSaveRequest commentSaveRequest);

    void deleteComment(Long commentId);




}
