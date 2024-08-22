package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    /*This method should call userservice to validate the token,if token is valid return
    corresponding object else return empty
    * */
    public Optional<JWTObject> validate(String token){
    RestTemplate restTemplate=restTemplateBuilder.build();
    return Optional.empty();
    }
}
