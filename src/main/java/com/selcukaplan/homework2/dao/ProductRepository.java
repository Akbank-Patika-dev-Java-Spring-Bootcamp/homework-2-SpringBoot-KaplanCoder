package com.selcukaplan.homework2.dao;

import com.selcukaplan.homework2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
