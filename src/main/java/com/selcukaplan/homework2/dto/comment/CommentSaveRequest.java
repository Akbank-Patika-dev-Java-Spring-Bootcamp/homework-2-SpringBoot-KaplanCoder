package com.selcukaplan.homework2.dto.comment;

public record CommentSaveRequest(Long userId,
                                 Long productId,
                                 String description) {
}
