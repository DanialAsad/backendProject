package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.NotFoundException;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //find how to change response status
        return exceptionDto;
        //return responseEntity;
    }

    @ExceptionHandler(NotFoundException.class)
    /*@ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()*/
    private ResponseEntity<ExceptionDto> handleNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //find how to change response status
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
        //return exceptionDto;
        //return responseEntity;
    }
}
