package com.example.runs.exception;

public class DuplicateRunException extends RuntimeException {

    public DuplicateRunException(String message) {
        super(message);
    }
}