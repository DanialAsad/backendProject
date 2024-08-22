package com.productservice.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JWTObject {
    //This is a kind of DTO object
    private String email;

    private Long userId;

    private Date createdAt;

    private Date expiryAt;

    private List<Role> roles;
}
