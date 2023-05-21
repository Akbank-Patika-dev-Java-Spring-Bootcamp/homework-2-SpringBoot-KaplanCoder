package com.selcukaplan.homework2.dto;

public record CommentDTO(Long id,
                         Long userId,
                         Long productId,
                         String value) {
}
