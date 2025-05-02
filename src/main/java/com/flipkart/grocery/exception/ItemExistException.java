package com.flipkart.grocery.exception;

public class ItemExistException extends RuntimeException{

    public ItemExistException(String message) {
        super(message);
    }

}
