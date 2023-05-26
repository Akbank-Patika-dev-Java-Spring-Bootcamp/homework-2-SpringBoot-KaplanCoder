package com.selcukaplan.homework2.controller;




import com.selcukaplan.homework2.controller.contract.ProductControllerContract;
import com.selcukaplan.homework2.dto.product.ProductSaveRequest;
import com.selcukaplan.homework2.dto.product.ProductDTO;
import com.selcukaplan.homework2.dto.user.UserDeleteRequest;
import com.selcukaplan.homework2.dto.user.UserSaveRequest;
import com.selcukaplan.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> saveProduct(@RequestBody ProductSaveRequest productSaveRequest) {
        ProductDTO ProductDTO = productControllerContract.saveProduct(productSaveRequest);
        return ResponseEntity.ok(RestResponse.of(ProductDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        ProductDTO ProductDTO = productControllerContract.getProduct(id);
        return ResponseEntity.ok(RestResponse.of(ProductDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> updatePrice(@PathVariable Long id,@RequestBody ProductSaveRequest productSaveRequest) {
        ProductDTO ProductDTO = productControllerContract.updatePrice(id,productSaveRequest.price());
        return ResponseEntity.ok(RestResponse.of(ProductDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAllProducts() {
        List<ProductDTO> productsDTO = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> deleteProduct(@PathVariable Long id) {
        productControllerContract.deleteProduct(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
