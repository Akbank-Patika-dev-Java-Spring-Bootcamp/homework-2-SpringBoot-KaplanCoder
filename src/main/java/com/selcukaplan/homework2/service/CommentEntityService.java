package com.selcukaplan.homework2.service;

import com.selcukaplan.homework2.dao.CommentRepository;
import com.selcukaplan.homework2.entity.Comment;
import com.selcukaplan.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;


@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {


    public CommentEntityService(CommentRepository repository) {
        super(repository);
    }

}
