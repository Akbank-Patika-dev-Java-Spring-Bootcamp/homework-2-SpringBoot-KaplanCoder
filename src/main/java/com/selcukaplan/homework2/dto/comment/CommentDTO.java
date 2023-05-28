package com.selcukaplan.homework2.dto.comment;

import java.time.LocalDateTime;

public record CommentDTO(Long id,
                         Long userId,
                         Long productId,
                         String description,
                         LocalDateTime createDate,
                         LocalDateTime updateDate) {
}
