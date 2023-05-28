package com.selcukaplan.homework2.dto.product;

import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String productName,
                         Double price,
                         LocalDateTime createDate,
                         LocalDateTime updateDate) {


}
