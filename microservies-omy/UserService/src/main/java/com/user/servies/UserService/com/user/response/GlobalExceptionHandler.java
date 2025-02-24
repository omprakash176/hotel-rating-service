package com.user.servies.UserService.com.user.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){

        String msg = ex.getMessage();
        ApiResponse response =   ApiResponse.builder().msg(msg).success(true).status(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
