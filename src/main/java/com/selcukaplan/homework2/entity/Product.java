package com.selcukaplan.homework2.entity;

import com.selcukaplan.homework2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name = "PRODUCTS")
@Getter
@Setter
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
  private Long id;

  @NotBlank
  @Column(name = "PRODUCTNAME",length = 50, nullable = false)
  private String productName;

  @NotBlank
  @Column(name = "PRICE", length = 50, nullable = false)
  private Double price;



}
