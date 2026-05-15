package com.example.runs.repository;

import com.example.runs.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;
import com.example.runs.model.Location;

public interface RunRepository extends JpaRepository<Run, Integer> {

    // Trova tutte le corse con un titolo specifico
    List<Run> findByTitle(String title);

    // Trova tutte le corse con miglia maggiori di una soglia
    List<Run> findByMilesGreaterThan(double miles);

    // Trova corse per location
    List<Run> findByLocation(Location location);

    // Combina condizioni con AND
    List<Run> findByLocationAndMilesGreaterThan(Location location, double miles);


    // Verifica se esiste una corsa con un certo titolo
    boolean existsByTitle(String title);
    List<Run> findByStartedOnBetween(LocalDateTime start, LocalDateTime end);

List<Run> findByTitleContainingIgnoreCase(String title);
}