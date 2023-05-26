package com.selcukaplan.homework2.dto.comment;

public record CommentDTO(Long id,
                         Long userId,
                         Long productId,
                         String value) {
}
