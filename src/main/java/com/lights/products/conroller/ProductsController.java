package com.lights.products.conroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lights.products.service.ProductsService;
import com.lights.products.model.Products;
import com.lights.products.model.entity.ProductsEntity;
import com.lights.products.model.request.ProductsRequest;
import com.lights.products.model.response.ProductsSaveSuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/products/add", consumes = {"application/json"})
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> addProductsToCatalogue(@RequestBody @Valid ProductsRequest productsRequest) {
        log.info("EventReceived = AddProductsToCatalogue ,InputRequest ={}", productsRequest.toString());
        productsService.addProductsToCatalogue(productsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductsSaveSuccessResponse("Products successfully saved"));
    }

    @GetMapping(value = "/products/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getProductByID(@PathVariable Long id) {
         log.info("EventReceived = GetProductById , Id =" + id);
         Products getByIdSuccessResponse = productsService.getProductById(id);
         return ResponseEntity.status(HttpStatus.OK).body(getByIdSuccessResponse);
    }


    @GetMapping(value = "/products")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?>  displayPageByPageNumSize(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        log.info("EventReceived = displayProductsByPageNumber&PageSize , PageNumber = {} PageSize = {}" + pageNumber, pageSize);
        Page<ProductsEntity> productlist = productsService.displayPageByPageNumSize(pageNumber, pageSize);
           return ResponseEntity.status(HttpStatus.OK).body(productlist);

    }

}
