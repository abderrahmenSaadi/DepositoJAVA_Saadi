package com.example.runs.dto;

import java.time.LocalDateTime;

public record RunResponse(

        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        double miles,
        String location
) {
}