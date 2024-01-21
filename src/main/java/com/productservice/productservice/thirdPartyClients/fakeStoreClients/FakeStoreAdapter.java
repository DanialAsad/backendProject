package com.productservice.productservice.thirdPartyClients.fakeStoreClients;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.ThirdPartyInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreAdapter {
    private RestTemplateBuilder restTemplateBuilder;

    private String specificProductUrl ="https://fakestoreapi.com/products/{id}";

    private String genericProductUrl ="https://fakestoreapi.com/products";

    FakeStoreAdapter(RestTemplateBuilder restTemplateBuilder){
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

    public FakeStoreProductDto  getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore Api
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.getForEntity(specificProductUrl,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("id not exist"+id);
        }
        return responseEntity.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);
        //List<GenericProductDto> result=new ArrayList<GenericProductDto>();
        List<FakeStoreProductDto> list=List.of(responseEntity.getBody());
        /*for(FakeStoreProductDto fkd:list){
            result.add(convertFakeProdToGenericProd(fkd));
        }*/
        return list;
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(specificProductUrl,id);

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();

    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);
        return responseEntity.getBody();

    }


    public void updateProduct() {

    }
}
