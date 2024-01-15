package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//Use restController if we are using rest api in that controller
    @RestController
    @RequestMapping("/products")
    public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
        //return "ScalerII Product fethed with id "+id;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return  productService.getAllProducts();
    }

    @DeleteMapping("/id")
    public void deleteProductById(){}

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

}
