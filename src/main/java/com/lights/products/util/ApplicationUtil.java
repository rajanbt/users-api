package com.lights.products.util;

import com.lights.products.model.response.ErrorDetails;
import com.lights.products.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Slf4j
public class ApplicationUtil {

//    public static String generateToken(String payload, Integer expiry) {
//        String token = Jwts.builder()
//                .setSubject(payload)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiry))
//                .signWith(SignatureAlgorithm.HS256, "key".getBytes()).compact();
//        return token;
//    }

//    public static Claims verifyToken(String token) {
//        Claims claimsJws = Jwts.parser()
//                .setSigningKey("key".getBytes())
//                .parseClaimsJws(token)
//                .getBody();
//        return claimsJws;
//    }

    public static ErrorResponse buildErrorResponse(String message, List<ErrorDetails> errors) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(UUID.randomUUID());
        errorResponse.setErrors(errors);
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public static ErrorResponse buildErrorResponse(String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(UUID.randomUUID());
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public static ErrorDetails buildValidationError(String message, String field) {
        ErrorDetails error = new ErrorDetails();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setField(field);
        error.setMessage(message);
        return error;
    }

    public static ErrorDetails buildValidationError(String message) {
        ErrorDetails error = new ErrorDetails();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(message);
        return error;
    }
}
