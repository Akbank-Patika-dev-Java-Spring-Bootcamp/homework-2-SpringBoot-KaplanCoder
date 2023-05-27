package com.selcukaplan.homework2.controller;

import com.selcukaplan.homework2.controller.contract.CommentControllerContract;
import com.selcukaplan.homework2.dto.comment.CommentDTO;
import com.selcukaplan.homework2.dto.comment.CommentSaveRequest;
import com.selcukaplan.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> saveComment(@RequestBody CommentSaveRequest commentSaveRequest) {
        CommentDTO commentDTO = commentControllerContract.saveComment(commentSaveRequest);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getCommentsByUserId(@PathVariable("id") Long userId) {
        List<CommentDTO> commentDTOs = commentControllerContract.getCommentsOfUser(userId);
        return ResponseEntity.ok(RestResponse.of(commentDTOs));
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getCommentsByProductId(@PathVariable("id") Long productId) {
        List<CommentDTO> commentDTOs = commentControllerContract.getCommentsOfProduct(productId);
        return ResponseEntity.ok(RestResponse.of(commentDTOs));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> deleteUser(@PathVariable Long id) {
        commentControllerContract.deleteComment(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
