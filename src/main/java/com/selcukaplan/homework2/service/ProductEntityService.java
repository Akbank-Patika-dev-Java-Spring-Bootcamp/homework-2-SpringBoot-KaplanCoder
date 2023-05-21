package com.selcukaplan.homework2.service;

import com.selcukaplan.homework2.dao.ProductRepository;
import com.selcukaplan.homework2.dao.UserRepository;
import com.selcukaplan.homework2.entity.Product;
import com.selcukaplan.homework2.entity.User;
import com.selcukaplan.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;


@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {


    public ProductEntityService(ProductRepository repository) {
        super(repository);
    }
}
