package com.selcukaplan.homework2.controller.contract.impl;

import com.selcukaplan.homework2.controller.contract.ProductControllerContract;
import com.selcukaplan.homework2.dto.product.ProductDTO;
import com.selcukaplan.homework2.dto.product.ProductSaveRequest;
import com.selcukaplan.homework2.entity.Product;
import com.selcukaplan.homework2.exception.NotFound;
import com.selcukaplan.homework2.mapper.ProductMapper;
import com.selcukaplan.homework2.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productEntityService.findAll();
        return ProductMapper.INSTANCE.productsToProductsDTOList(products);
    }

    @Override
    public ProductDTO getProduct(Long productId) {
        Optional<Product> productOptional= productEntityService.findById(productId);
        if (productOptional.isEmpty()) {
            throw new NotFound("Product with " + productId + " id is not found!");
        }
        return ProductMapper.INSTANCE.productToProductDTO(productOptional.get());
    }

    @Override
    public ProductDTO saveProduct(ProductSaveRequest saveRequest) {
        Product newProduct = ProductMapper.INSTANCE.saveRequestToProduct(saveRequest);
        newProduct = productEntityService.save(newProduct);
        return ProductMapper.INSTANCE.productToProductDTO(newProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> productOptional = productEntityService.findById(productId);
        if (productOptional.isEmpty()) {
            throw new NotFound("Product with " + productId + " id is not found!");
        }
        productEntityService.delete(productOptional.get());

    }

    @Override
    public ProductDTO updatePrice(Long productId,Double  price) {
        Optional<Product> productOptional = productEntityService.findById(productId);
        if (productOptional.isEmpty()) {
            throw new NotFound("Product with " + productId + " id is not found!");
        }
        Product updatedProduct = productOptional.get();
        updatedProduct.setPrice(price);
        productEntityService.save(updatedProduct);
        return ProductMapper.INSTANCE.productToProductDTO(updatedProduct);

    }
}
