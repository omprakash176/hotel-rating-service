package com.servies.hotel.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> notFound( ResourceNotFoundException resourceNotFoundException) {

        Map<String, Object> map = Map.of("message", resourceNotFoundException.getMessage());
        if(Objects.nonNull(resourceNotFoundException.getCause())) {
            map.put("msg", resourceNotFoundException.getCause().getMessage());
            map.put("success", false);
            map.put("status", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
