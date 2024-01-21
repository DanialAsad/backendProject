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
import com.productservice.productservice.thirdPartyClients.fakeStoreClients.FakeStoreAdapter;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

private FakeStoreAdapter fakeStoreAdapter;

    FakeStoreProductService(FakeStoreAdapter fakeStoreAdapter){
        this.fakeStoreAdapter=fakeStoreAdapter;
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
        //return fakeStoreAdapter.getProductById(id);
        return convertFakeProdToGenericProd(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductDto> list=fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> result=new ArrayList<GenericProductDto>();
        for(FakeStoreProductDto fkd:list) {
            result.add(convertFakeProdToGenericProd(fkd));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
           return convertFakeProdToGenericProd(fakeStoreAdapter.deleteProduct(id));

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
      return convertFakeProdToGenericProd(fakeStoreAdapter.createProduct(genericProductDto));

    }

    @Override
    public void updateProduct() {

    }
}
