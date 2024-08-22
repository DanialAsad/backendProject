package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.service.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /*@Test
    @DisplayName("Assert 1+1 is 2")
    void testOnePlusOneIsTwo(){
        //assert(2==1+1,"1+1 is not equal to given no.");
        assertEquals(11,1+1,"1+1 is not equal to given no.");

    }
    @Test
    @DisplayName("Assert getProductById")
    void testGetProductByIdNegativeTC(){
        assertThrows(ProductNotFoundException.class,()->productController.getProductById(1000L));
    }

    @Test
    void testGetProductByIDMocking() throws ProductNotFoundException{
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setTitle("iphone mock");
        //when(productService.getProductById(1000L)).thenReturn(genericProductDto);
        when(productService.getProductById(1L)).thenReturn(genericProductDto);
        GenericProductDto genericProductDto1=productController.getProductById(1L);

        assertEquals(genericProductDto,genericProductDto1);
    }

    @Test
    void testGetProductByIDMockingException() throws ProductNotFoundException{


        //when(productService.getProductById(1000L)).thenReturn(genericProductDto);
        when(productService.getProductById(any(Long.class))).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class,()->productController.getProductById(1L));
    }*/
}
