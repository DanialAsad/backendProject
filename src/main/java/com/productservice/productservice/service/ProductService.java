package com.productservice.productservice.service;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ProductService {

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    void deleteProduct();

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProduct();
}
