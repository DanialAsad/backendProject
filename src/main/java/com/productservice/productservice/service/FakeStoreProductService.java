package com.productservice.productservice.service;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private String specificProductUrl ="https://fakestoreapi.com/products/{id}";

    private String genericProductUrl ="https://fakestoreapi.com/products";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public static GenericProductDto convertFakeProdToGenericProd(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
    @Override
    public GenericProductDto  getProductById(Long id) throws ProductNotFoundException{
        //Integrate the FakeStore Api
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.getForEntity(specificProductUrl,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("id not exist"+id);
        }
        return convertFakeProdToGenericProd(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);
        List<GenericProductDto> result=new ArrayList<GenericProductDto>();
        List<FakeStoreProductDto> list=List.of(responseEntity.getBody());
        for(FakeStoreProductDto fkd:list){
            result.add(convertFakeProdToGenericProd(fkd));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(specificProductUrl,id);

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return convertFakeProdToGenericProd(responseEntity.getBody());

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);
        return convertFakeProdToGenericProd(responseEntity.getBody());

    }

    @Override
    public void updateProduct() {

    }
}
