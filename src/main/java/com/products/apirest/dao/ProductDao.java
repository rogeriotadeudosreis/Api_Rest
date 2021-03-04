package com.products.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.apirest.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

	Product findById(long id);
}
