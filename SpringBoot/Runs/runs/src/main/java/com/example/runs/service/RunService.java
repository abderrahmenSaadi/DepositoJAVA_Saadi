package com.example.runs.service;

import com.example.runs.dto.RunResponse;
import com.example.runs.exception.DuplicateRunException;
import com.example.runs.exception.RunNotFoundException;
import com.example.runs.model.Run;
import com.example.runs.model.Location;
import com.example.runs.repository.RunRepository;
import com.example.runs.dto.RunRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RunService {

    private final RunRepository runRepository;

    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // CREATE
    public RunResponse createRun(RunRequest request) {

        if (runRepository.existsByTitle(request.title())) {
            throw new DuplicateRunException(
                    "A run with this title already exists");
        }

        Run run = toEntity(request);

        Run savedRun = runRepository.save(run);

        return toResponse(savedRun);
    }

    // GET BY ID
    public RunResponse getRunById(Integer id) {

        Run run = runRepository.findById(id)
                .orElseThrow(() ->
                        new RunNotFoundException("Run not found"));

        return toResponse(run);
    }

    // UPDATE
    public RunResponse updateRun(Integer id, RunRequest request) {

        Run existingRun = runRepository.findById(id)
                .orElseThrow(() ->
                        new RunNotFoundException("Run not found"));

        if (!existingRun.getTitle().equals(request.title())
                && runRepository.existsByTitle(request.title())) {

            throw new DuplicateRunException(
                    "Another run with this title already exists");
        }

        existingRun.setTitle(request.title());
        existingRun.setStartedOn(request.startedOn());
        existingRun.setCompletedOn(request.completedOn());
        existingRun.setMiles(request.miles());
        existingRun.setLocation(request.location());

        Run updatedRun = runRepository.save(existingRun);

        return toResponse(updatedRun);
    }

    // DELETE
    public void deleteRun(Integer id) {

        if (!runRepository.existsById(id)) {
            throw new RunNotFoundException("Run not found");
        }

        runRepository.deleteById(id);
    }

    // GET ALL
    public List<RunResponse> getAllRuns() {

        return runRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BY TITLE
    public List<RunResponse> getRunsByTitle(String title) {

        return runRepository.findByTitle(title)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BY TITLE LIKE
    public List<RunResponse> getRunsByTitleContaining(String title) {

        return runRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BY MILES
    public List<RunResponse> getRunsByMilesGreaterThan(double miles) {

        if (miles < 0) {
            throw new IllegalArgumentException(
                    "Miles cannot be negative");
        }

        return runRepository.findByMilesGreaterThan(miles)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BY LOCATION
    public List<RunResponse> getRunsByLocation(Location location) {

        return runRepository.findByLocation(location)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BY LOCATION + MILES
    public List<RunResponse> getRunsByLocationAndMilesGreaterThan(
            Location location,
            double miles) {

        if (miles < 0) {
            throw new IllegalArgumentException(
                    "Miles cannot be negative");
        }

        return runRepository
                .findByLocationAndMilesGreaterThan(location, miles)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // FIND BETWEEN DATES
    public List<RunResponse> getRunsByStartedOnBetween(
            LocalDateTime start,
            LocalDateTime end) {

        if (end.isBefore(start)) {
            throw new IllegalArgumentException(
                    "End date must be after start date");
        }

        return runRepository.findByStartedOnBetween(start, end)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // DTO -> ENTITY
    private Run toEntity(RunRequest request) {

        return new Run(
                request.title(),
                request.startedOn(),
                request.completedOn(),
                request.miles(),
                request.location()
        );
    }

    // ENTITY -> DTO
    private RunResponse toResponse(Run run) {

        return new RunResponse(
                run.getId(),
                run.getTitle(),
                run.getStartedOn(),
                run.getCompletedOn(),
                run.getMiles(),
                run.getLocation().name()
        );
    }
}