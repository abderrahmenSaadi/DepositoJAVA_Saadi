package com.example.runs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "runs")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100,
            message = "Title must be between 3 and 100 characters")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotNull(message = "Started date is required")
    @Column(name = "started_on", nullable = false)
    private LocalDateTime startedOn;

    @NotNull(message = "Completed date is required")
    @Column(name = "completed_on", nullable = false)
    private LocalDateTime completedOn;

    @Positive(message = "Miles must be positive")
    @Max(value = 200, message = "Miles cannot exceed 200")
    @Column(name = "miles", nullable = false)
    private double miles;

    @NotNull(message = "Location is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "location", nullable = false)
    private Location location;

    protected Run() {
    }

    public Run(String title,
               LocalDateTime startedOn,
               LocalDateTime completedOn,
               double miles,
               Location location) {

        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public double getMiles() {
        return miles;
    }

    public Location getLocation() {
        return location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}