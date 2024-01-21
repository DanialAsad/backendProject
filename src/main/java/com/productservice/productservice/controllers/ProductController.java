package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
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
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{

        return productService.getProductById(id);
        //return "ScalerII Product fethed with id "+id;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return  productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){

        return productService.deleteProduct(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    public void updateProductById(){}

   /* @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //find how to change response status
        ResponseEntity responseEntity=new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
        return responseEntity;
    }*/
}
