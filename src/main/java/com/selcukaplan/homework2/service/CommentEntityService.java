package com.selcukaplan.homework2.service;

import com.selcukaplan.homework2.dao.CommentRepository;
import com.selcukaplan.homework2.entity.Comment;
import com.selcukaplan.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {


    public CommentEntityService(CommentRepository repository) {
        super(repository);
    }


    public List<Comment> findCommentsByUserId(Long userId) {
        return repository.findCommentByUserId(userId);
    }

    public List<Comment> findCommentsByProductId(Long productId) {
        return repository.findCommentByProductId(productId);
    }
}
