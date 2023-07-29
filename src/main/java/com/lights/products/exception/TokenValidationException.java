package com.lights.products.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class TokenValidationException extends RuntimeException {

    public TokenValidationException(String message) {
        super(message);
    }
}
