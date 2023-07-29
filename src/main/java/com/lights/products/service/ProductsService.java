package com.lights.products.service;

import com.lights.products.exception.ProductsNotFoundException;
import com.lights.products.model.entity.ProductsEntity;
import com.lights.products.model.Products;
import com.lights.products.model.request.ProductsRequest;
import com.lights.products.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public ProductsRequest addProductsToCatalogue(ProductsRequest productsRequest) {
        List<ProductsEntity> productsEntityList = new ArrayList<>();
        List<Products> productsRequestList = productsRequest.getProductList();
        for (int i = 0; i < productsRequestList.size(); i++) {
            ProductsEntity productsEntity = ProductsEntity.builder()
                    .productCode(productsRequestList.get(i).getProductCode())
                    .productStatus(productsRequestList.get(i).getProductStatus())
                    .price(productsRequestList.get(i).getPrice())
                    .division(productsRequestList.get(i).getDivision())
                    .gender(productsRequestList.get(i).getGender())
                    .releaseDate(productsRequestList.get(i).getReleaseDate())
                    .colour(productsRequestList.get(i).getColour())
                    .quantity(productsRequestList.get(i).getQuantity())
                    .age(productsRequestList.get(i).getAge())
                    .build();
            productsEntityList.add(productsEntity);
        }

        productsRepository.saveAll(productsEntityList);
        return productsRequest;
    }

    public Products getProductById(Long id) {

        ProductsEntity productEntity = productsRepository.getById(id);
        if (!(productEntity == null)) {
            Products productResponse = Products.builder()
                    .productCode(productEntity.getProductCode())
                    .productStatus(productEntity.getProductStatus())
                    .age(productEntity.getAge())
                    .quantity(productEntity.getQuantity())
                    .colour(productEntity.getColour())
                    .gender(productEntity.getGender())
                    .releaseDate(productEntity.getReleaseDate())
                    .division(productEntity.getDivision())
                    .price(productEntity.getPrice())
                    .build();
            log.info("getProductById SuccessResponse ={}", productResponse);
            return productResponse;
        } else
        {
            throw new ProductsNotFoundException("Product Not Found");
        }
        }

    public Page<ProductsEntity> displayPageByPageNumSize(Integer pageNum, Integer pageSize) {
//         if ((pageNum != null) && (pageSize != null)){
             Pageable pageing = PageRequest.of(pageNum, pageSize, Sort.by("id").ascending());
             Page<ProductsEntity> getByPageNumSize = productsRepository.getAllProducts(pageing);

//             List<ProductsEntity> getByPageNumSizeList =  getByPageNumSize.getContent();;
//
//             List<Products> responseList = new ArrayList<>();
//             for (int i = 0; i < getByPageNumSizeList.size(); i++) {
////                  if (getByPageNumSizeList != null) {
//                      Products productResponse = Products.builder()
//                              .productCode(responseList.get(i).getProductCode())
//                              .productStatus(responseList.get(i).getProductStatus())
//                              .age(responseList.get(i).getAge())
//                              .quantity(responseList.get(i).getQuantity())
//                              .colour(responseList.get(i).getColour())
//                              .gender(responseList.get(i).getGender())
//                              .releaseDate(responseList.get(i).getReleaseDate())
//                              .division(responseList.get(i).getDivision())
//                              .price(responseList.get(i).getPrice())
//                              .build();
//                      responseList.add(productResponse);
//
////                  }
//             }

//         }
//         else {
//             Iterable<ProductsEntity> productResponseList = productsRepository.findAll();
//
//         }
//        log.info("DisplayByPageNumSize SuccessResponse =" + responseList.toString() + getByPageNumSize.toString());
        return getByPageNumSize;
    }

}
