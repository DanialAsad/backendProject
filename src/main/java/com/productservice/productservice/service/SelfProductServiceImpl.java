package com.productservice.productservice.service;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class SelfProductServiceImpl implements  ProductService{

    private ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Make a DB call & get the product with given id
        GenericProductDto genericProductDto=new GenericProductDto();
        Optional<Product> optionalProduct=productRepository.findById(UUID.fromString("26c0039d-1f1f-4c99-b9ab-b88a35cc072e"));

        Product product=optionalProduct.get();

        genericProductDto.setImage(product.getImage());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setCategory(product.getCategory().toString());
        genericProductDto.setDescription(product.getDescription());
       // genericProductDto.setPrice(Integer.valueOf(product.getPrice()));

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public void updateProduct() {

    }
}
