package com.selcukaplan.homework2.mapper;


import com.selcukaplan.homework2.dto.ProductDTO;
import com.selcukaplan.homework2.dto.user.UserDTO;
import com.selcukaplan.homework2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    Product productDTOtoProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductsDTOList(List<Product> products);

}
