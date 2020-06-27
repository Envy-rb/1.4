package com.envy.day41.exception;

public class OutOfRangeException extends Exception {
    private final static String messageString = "Array index out of bounds";

    public OutOfRangeException() {
        super(messageString);
    }
}
