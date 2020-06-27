package com.envy.day41.exception;

public class CustomNegativeArraySizeException extends Exception{
    private final static String messageString = "Array length must be a positive number";

    public CustomNegativeArraySizeException() {
        super(messageString);
    }
}
