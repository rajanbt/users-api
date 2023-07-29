package com.lights.products.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lights.products.model.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class PaginationSuccessResponse {

    private List<Products> RespList;

}
