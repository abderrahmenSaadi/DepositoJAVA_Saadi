package com.example.runs.exception;

public class RunNotFoundException extends RuntimeException {

    public RunNotFoundException(String message) {
        super(message);
    }
}