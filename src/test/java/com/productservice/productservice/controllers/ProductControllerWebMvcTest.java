package com.productservice.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.service.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Inject
    private ObjectMapper objectMapper;
    @Test
    void testAllProductsReturnsValidList() throws Exception{

        List<GenericProductDto> genericProductDtoList=new ArrayList<>();
        genericProductDtoList.add(new GenericProductDto());
        genericProductDtoList.add(new GenericProductDto());
        genericProductDtoList.add(new GenericProductDto());

        when(productService.getAllProducts()).thenReturn(genericProductDtoList);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtoList)));

    }
    /*@Test
    void createProductShouldCreateAValidNewProduct() throws Exception{
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setTitle("Macbook");
        genericProductDto.setPrice(200000.0);
        genericProductDto.setDescription("Fastest mac ever");
        genericProductDto.setCategory("Laptop");

        GenericProductDto outputGenericProductDto=new GenericProductDto();
        outputGenericProductDto.setCategory(genericProductDto.getCategory());
        outputGenericProductDto.setDescription(genericProductDto.getDescription());
        outputGenericProductDto.setTitle(genericProductDto.getTitle());
        outputGenericProductDto.setPrice(genericProductDto.getPrice());
        outputGenericProductDto.setId(1000L);

        when(productService.createProduct(any())).thenReturn(outputGenericProductDto);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(genericProductDto)))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(outputGenericProductDto)))
                .andExpect(jsonPath("$.product.title", is("iPhone")))
                .andExpect(jsonPath("$.product.price" , is(20000)));

    }*/
}
