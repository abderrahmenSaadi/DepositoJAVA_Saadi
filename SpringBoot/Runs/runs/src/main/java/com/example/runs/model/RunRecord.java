package com.example.runs.model;
import java.time.LocalDateTime;

public record RunRecord(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Double miles, Location location ){
    public RunRecord {
        if (miles != null && miles < 0) {
            throw new IllegalArgumentException("i chilometri non possono essere negativi");
        }
        if(completedOn != null && startedOn != null && completedOn.isBefore(startedOn)){
            throw new IllegalArgumentException("la data di fine non può precedere quella di inizio");
        }
    }
    
}