package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handleexception extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomNotFoundException.class})
    public ResponseEntity<Object> handleException(CustomNotFoundException ex){
        ApiError apiError=new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                ex.getCause()
        );
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
}
