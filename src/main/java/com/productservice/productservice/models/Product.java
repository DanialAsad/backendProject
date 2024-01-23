package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private int price;
    private String image;
    //Category is not a primitive attribute
    //1 product belongs to 1 category
    //1 category contains many products
    @ManyToOne
    private Category category;

}
