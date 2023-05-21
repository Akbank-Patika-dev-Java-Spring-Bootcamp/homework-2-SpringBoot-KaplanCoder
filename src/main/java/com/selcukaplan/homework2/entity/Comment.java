package com.selcukaplan.homework2.entity;

import com.selcukaplan.homework2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "USERID", nullable = false)
    private Long userId;

    @NotBlank
    @Column(name = "PRODUCTID",nullable = false)
    private Long productId;

    @Column(name = "VALUE", length = 100, nullable = false)
    private String description;



}
