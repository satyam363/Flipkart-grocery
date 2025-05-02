package com.flipkart.grocery.exception;

import com.flipkart.grocery.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(ItemExistException.class)
    public ResponseEntity<APIResponse> itemAlreadyExistsExceptionHandler(ItemExistException ex) {
        APIResponse apiResponse = new APIResponse(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ItemNotExistsException.class)
    public ResponseEntity<APIResponse> itemNotExistsExceptionHandler(ItemNotExistsException ex) {
        APIResponse apiResponse = new APIResponse(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotCreatedException.class)
    public ResponseEntity<APIResponse> itemNotCreatedException(ItemNotCreatedException ex) {
        APIResponse apiResponse = new APIResponse(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
