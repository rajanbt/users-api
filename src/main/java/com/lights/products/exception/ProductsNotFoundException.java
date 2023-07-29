package com.lights.products.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductsNotFoundException extends RuntimeException {

    public ProductsNotFoundException(String message) {
        super(message);
    }
}
