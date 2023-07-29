package com.lights.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

   @NotBlank(message = "Please provide productCode")
    private String productCode;
   @NotBlank(message = "Please provide colour")
   private String colour;
   @NotBlank(message = "Please provide Gender")
    private String gender;
   @NotNull(message = "Please provide Division")
    private Division division;
   @NotNull(message = "Please provide Age")
    private Age age;
   @NotNull(message = "Please provide Product Status")
    private ProductStatus productStatus;
   @NotBlank(message = "Please provide Release Date")
    private String releaseDate;
   @NotNull(message = "Please provide the Price")
    private Integer price;
   @NotNull(message = "Please provide the quantity")
   private Integer quantity;


}
