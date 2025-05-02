package com.flipkart.grocery.exception;

public class ItemNotExistsException extends RuntimeException{

    public ItemNotExistsException(String message) {
        super(message);
    }

}
