package com.selcukaplan.homework2.dao;

import com.selcukaplan.homework2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT c FROM Comment c where c.userId = :userId")
    List<Comment> findCommentByUserId(@Param("userId") Long userId);

    @Query(value= "SELECT c FROM Comment c where c.productId = :productId")
    List<Comment> findCommentByProductId(@Param("productId") Long productId);
}
