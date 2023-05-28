package com.selcukaplan.homework2.mapper;


import com.selcukaplan.homework2.dto.comment.CommentDTO;
import com.selcukaplan.homework2.dto.comment.CommentSaveRequest;
import com.selcukaplan.homework2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE) // Todo: why it is used. will be researched
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    @Mapping(target = "createDate",source = "comment.baseAdditionalFields.createDate")
    @Mapping(target = "updateDate",source = "comment.baseAdditionalFields.updateDate")
    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);

    Comment saveRequestToComment(CommentSaveRequest commentSaveRequest);

    List<CommentDTO> commentsToCommentsDTOList(List<Comment> comments);

}
