package com.example.runs.exception;

import java.time.LocalDateTime;

public record ErrorResponse(

        String message,
        int status,
        LocalDateTime timestamp
) {}