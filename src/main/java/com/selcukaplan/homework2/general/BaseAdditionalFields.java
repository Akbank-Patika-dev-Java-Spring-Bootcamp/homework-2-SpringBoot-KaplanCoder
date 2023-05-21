package com.selcukaplan.homework2.general;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  @Column(name = "CREATED_BY")
  private Long createdBy;

  @Column(name = "UPDATED_BY")
  private Long updatedBy;

  @Column(name = "CREATED_AT")
  private LocalDateTime createDate;

  @Column(name = "UPDATE_DATE")
  private LocalDateTime updateDate;
}
