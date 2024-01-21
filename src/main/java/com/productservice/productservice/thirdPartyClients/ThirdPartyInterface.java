package com.productservice.productservice.thirdPartyClients;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyInterface {

    GenericProductDto getProductById(Long id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProduct();
}
