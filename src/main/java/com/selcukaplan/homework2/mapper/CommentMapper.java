package com.selcukaplan.homework2.mapper;


import com.selcukaplan.homework2.dto.CommentDTO;
import com.selcukaplan.homework2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);

    List<CommentDTO> commentsToCommentsDTOList(List<Comment> comments);

}
