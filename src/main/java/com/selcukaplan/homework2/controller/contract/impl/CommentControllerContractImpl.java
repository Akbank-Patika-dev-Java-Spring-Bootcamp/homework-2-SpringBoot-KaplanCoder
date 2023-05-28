package com.selcukaplan.homework2.controller.contract.impl;

import com.selcukaplan.homework2.controller.contract.CommentControllerContract;
import com.selcukaplan.homework2.dto.comment.CommentDTO;
import com.selcukaplan.homework2.dto.comment.CommentSaveRequest;
import com.selcukaplan.homework2.entity.Comment;
import com.selcukaplan.homework2.exception.NotFound;
import com.selcukaplan.homework2.mapper.CommentMapper;
import com.selcukaplan.homework2.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService commentEntityService;

    @Override
    public List<CommentDTO> getCommentsOfUser(Long userId) {
        List<Comment> comments = commentEntityService.findCommentsByUserId(userId);
        if (comments.isEmpty()) {
            throw new NotFound("User with the " + userId +  " id does not have any comments.");
        }
        return CommentMapper.INSTANCE.commentsToCommentsDTOList(comments);
    }

    @Override
    public List<CommentDTO> getCommentsOfProduct(Long productId) {
        List<Comment> comments = commentEntityService.findCommentsByProductId(productId);
        if (comments.isEmpty()) {
            throw new NotFound("Product with the " + productId +  " id does not have any comments.");
        }
        return CommentMapper.INSTANCE.commentsToCommentsDTOList(comments);
    }

    @Override
    public CommentDTO saveComment(CommentSaveRequest commentSaveRequest) {
        Comment newComment = CommentMapper.INSTANCE.saveRequestToComment(commentSaveRequest);
        newComment = commentEntityService.save(newComment);
        return CommentMapper.INSTANCE.commentToCommentDTO(newComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Optional<Comment> commentOptional = commentEntityService.findById(commentId);
        if (commentOptional.isEmpty()) {
            throw new NotFound("Comment with the " + commentId +  " id is not found!");
        }
        commentEntityService.delete(commentId); // Todo: condition could be added to check whether deleted or not

    }
}
