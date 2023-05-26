package com.selcukaplan.homework2.controller.contract;

import com.selcukaplan.homework2.dto.product.ProductDTO;
import com.selcukaplan.homework2.dto.product.ProductSaveRequest;

import java.util.List;


public interface ProductControllerContract {

    List<ProductDTO> findAll();

    ProductDTO getProduct(Long productId);

    ProductDTO saveProduct(ProductSaveRequest saveRequest);

    void deleteProduct(Long productId);

    ProductDTO updatePrice(Long productId,Double price);


}
