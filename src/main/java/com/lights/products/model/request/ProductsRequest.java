package com.lights.products.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lights.products.model.Products;
import lombok.*;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsRequest {

    @NotEmpty
    @Valid
    private List<Products> productList;


}
