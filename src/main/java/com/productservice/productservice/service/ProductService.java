package com.productservice.productservice.service;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ProductService {

    GenericProductDto getProductById(String token,Long id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProduct();
}
