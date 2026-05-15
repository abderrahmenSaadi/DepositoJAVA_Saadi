package com.example.runs.controller;

import com.example.runs.dto.RunRequest;
import com.example.runs.dto.RunResponse;
import com.example.runs.model.Location;
import com.example.runs.service.RunService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<RunResponse>> findAll() {
        return ResponseEntity.ok(runService.getAllRuns());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<RunResponse> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                runService.getRunById(id)
        );
    }

    // CREATE
    @PostMapping
    public ResponseEntity<RunResponse> create(
            @Valid @RequestBody RunRequest request) {

        RunResponse response =
                runService.createRun(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RunResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody RunRequest request) {

        return ResponseEntity.ok(
                runService.updateRun(id, request)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        runService.deleteRun(id);

        return ResponseEntity.noContent().build();
    }

    // FIND BY MILES
    @GetMapping("/miles/{miles}")
    public ResponseEntity<List<RunResponse>>
    findByMilesGreaterThan(
            @PathVariable double miles) {

        return ResponseEntity.ok(
                runService.getRunsByMilesGreaterThan(miles)
        );
    }

    // FIND BY TITLE
    @GetMapping("/title/{title}")
    public ResponseEntity<List<RunResponse>> findByTitle(
            @PathVariable String title) {

        return ResponseEntity.ok(
                runService.getRunsByTitle(title)
        );
    }

    // FIND TITLE LIKE
    @GetMapping("/title-like/{title}")
    public ResponseEntity<List<RunResponse>> findTitleLike(
            @PathVariable String title) {

        return ResponseEntity.ok(
                runService.getRunsByTitleContaining(title)
        );
    }

    // FIND BY LOCATION
    @GetMapping("/location/{location}")
    public ResponseEntity<List<RunResponse>> findByLocation(
            @PathVariable Location location) {

        return ResponseEntity.ok(
                runService.getRunsByLocation(location)
        );
    }

    // FIND BY LOCATION + MILES
    @GetMapping("/location-miles")
    public ResponseEntity<List<RunResponse>>
    findByLocationAndMilesGreaterThan(
            @RequestParam Location location,
            @RequestParam double miles) {

        return ResponseEntity.ok(
                runService
                        .getRunsByLocationAndMilesGreaterThan(
                                location,
                                miles
                        )
        );
    }

    // FIND BETWEEN DATES
    @GetMapping("/started-between")
    public ResponseEntity<List<RunResponse>>
    findByStartedOnBetween(
            @RequestParam String start,
            @RequestParam String end) {

        LocalDateTime startDateTime =
                LocalDateTime.parse(start);

        LocalDateTime endDateTime =
                LocalDateTime.parse(end);

        return ResponseEntity.ok(
                runService.getRunsByStartedOnBetween(
                        startDateTime,
                        endDateTime
                )
        );
    }
}