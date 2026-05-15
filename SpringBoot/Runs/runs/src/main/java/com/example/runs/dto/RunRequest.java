package com.example.runs.dto;

import com.example.runs.model.Location;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record RunRequest(

        @NotBlank(message = "Title is required")
        @Size(min = 3, max = 100,
                message = "Title must be between 3 and 100 characters")
        String title,

        @NotNull(message = "Started date is required")
        LocalDateTime startedOn,

        @NotNull(message = "Completed date is required")
        LocalDateTime completedOn,

        @Positive(message = "Miles must be positive")
        @Max(value = 200, message = "Miles cannot exceed 200")
        double miles,

        @NotNull(message = "Location is required")
        Location location
) {
}