package com.example.runs.controller;

import com.example.runs.model.Location;
import com.example.runs.model.Run;
import com.example.runs.service.RunService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/runs")
@Validated
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runService.getAllRuns());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(runService.getRunById(id));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Run> create(@Valid @RequestBody Run run) {

        Run savedRun = runService.createRun(run);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedRun);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(
            @PathVariable Integer id,
            @Valid @RequestBody Run updatedRun) {

        return ResponseEntity.ok(
                runService.updateRun(id, updatedRun)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        runService.deleteRun(id);

        return ResponseEntity.noContent().build();
    }

    // FIND BY MILES
    @GetMapping("/miles/{miles}")
    public ResponseEntity<List<Run>> findByMilesGreaterThan(
            @PathVariable double miles) {

        return ResponseEntity.ok(
                runService.getRunsByMilesGreaterThan(miles)
        );
    }

    // FIND BY TITLE
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Run>> findByTitle(
            @PathVariable String title) {

        return ResponseEntity.ok(
                runService.getRunsByTitle(title)
        );
    }

    // FIND BY TITLE LIKE
    @GetMapping("/title-like/{title}")
    public ResponseEntity<List<Run>> findTitleLike(
            @PathVariable String title) {

        return ResponseEntity.ok(
                runService.getRunsByTitleContaining(title)
        );
    }

    // FIND BY LOCATION
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Run>> findByLocation(
            @PathVariable Location location) {

        return ResponseEntity.ok(
                runService.getRunsByLocation(location)
        );
    }

    // FIND BY LOCATION + MILES
    @GetMapping("/location-miles")
    public ResponseEntity<List<Run>> findByLocationAndMilesGreaterThan(
            @RequestParam Location location,
            @RequestParam double miles) {

        return ResponseEntity.ok(
                runService.getRunsByLocationAndMilesGreaterThan(
                        location,
                        miles
                )
        );
    }

    // FIND BETWEEN DATES
    @GetMapping("/started-between")
    public ResponseEntity<List<Run>> findByStartedOnBetween(
            @RequestParam String start,
            @RequestParam String end) {

        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);

        return ResponseEntity.ok(
                runService.getRunsByStartedOnBetween(
                        startDateTime,
                        endDateTime
                )
        );
    }
}