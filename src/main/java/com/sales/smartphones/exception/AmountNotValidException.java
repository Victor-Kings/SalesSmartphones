package com.sales.smartphones.exception;

public class AmountNotValidException extends RuntimeException{
    public AmountNotValidException(String message) {
        super(message);
    }
}
