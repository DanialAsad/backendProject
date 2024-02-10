package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAll();

    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleAndDescription(String title,String description);

    List<Product> findAllByPrice_ValueGreaterThan(Integer x);

    List<Product> findAllByPrice_ValueLessThan(Integer x);

    List<Product> findAllByPrice_ValueBetween(Integer x,Integer y);
}
