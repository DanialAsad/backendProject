package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

//DTO--> Data Transfer Object
@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

}
