package com.envy.day41.exception;

public class IncorrectInputDataException extends Exception{
    private final static String messageString = "Input stream does'n hava any values";

    public IncorrectInputDataException() {
        super(messageString);
    }
}
