package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;

    private String image;
    //Category is not a primitive attribute
    //1 product belongs to 1 category
    //1 category contains many products
    @ManyToOne(optional = false)
    //@JoinColumn(nullable = false)
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    //@JoinColumn(nullable = false)
    private Price price;
    private int inventoryCount;

}
