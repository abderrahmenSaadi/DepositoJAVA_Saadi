    package com.example.runs.service;

    import com.example.runs.model.Location;
    import com.example.runs.model.Run;
    import com.example.runs.repository.RunRepository;

    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;
    import com.example.runs.exception.DuplicateRunException;
    import com.example.runs.exception.RunNotFoundException;
    @Service
    public class RunService {

        private final RunRepository runRepository;

        public RunService(RunRepository runRepository) {
            this.runRepository = runRepository;
        }

        // CREATE
        public Run createRun(Run run) {


            if (runRepository.existsByTitle(run.getTitle())) {
                throw new DuplicateRunException(
            "A run with this title already exists");
            }

            return runRepository.save(run);
        }

        // GET BY ID
        public Run getRunById(Integer id) {
            return runRepository.findById(id)
                    .orElseThrow(() -> new RunNotFoundException("Run not found"));
        }

        // UPDATE
        public Run updateRun(Integer id, Run updatedRun) {


            Run existingRun = getRunById(id);

            // prevent duplicate title on update
            if (!existingRun.getTitle().equals(updatedRun.getTitle())
                    && runRepository.existsByTitle(updatedRun.getTitle())) {

                throw new DuplicateRunException(
            "Another run with this title already exists");
            }

            existingRun.setTitle(updatedRun.getTitle());
            existingRun.setStartedOn(updatedRun.getStartedOn());
            existingRun.setCompletedOn(updatedRun.getCompletedOn());
            existingRun.setMiles(updatedRun.getMiles());
            existingRun.setLocation(updatedRun.getLocation());

            return runRepository.save(existingRun);
        }

        // DELETE
        public void deleteRun(Integer id) {

            if (!runRepository.existsById(id)) {
                throw new RunNotFoundException("Run not found");
            }

            runRepository.deleteById(id);
        }

        // GET ALL
        public List<Run> getAllRuns() {
            return runRepository.findAll();
        }

        // FIND BY TITLE
        public List<Run> getRunsByTitle(String title) {
            return runRepository.findByTitle(title);
        }

        // FIND BY TITLE LIKE
        public List<Run> getRunsByTitleContaining(String title) {
            return runRepository.findByTitleContainingIgnoreCase(title);
        }

        // FIND BY MILES
        public List<Run> getRunsByMilesGreaterThan(double miles) {

            if (miles < 0) {
                throw new IllegalArgumentException("Miles cannot be negative");
            }

            return runRepository.findByMilesGreaterThan(miles);
        }

        // FIND BY LOCATION
        public List<Run> getRunsByLocation(Location location) {
            return runRepository.findByLocation(location);
        }

        // FIND BY LOCATION + MILES
        public List<Run> getRunsByLocationAndMilesGreaterThan(
                Location location,
                double miles) {

            if (miles < 0) {
                throw new IllegalArgumentException("Miles cannot be negative");
            }

            return runRepository.findByLocationAndMilesGreaterThan(location, miles);
        }

        // FIND BETWEEN DATES
        public List<Run> getRunsByStartedOnBetween(
                LocalDateTime start,
                LocalDateTime end) {

            if (end.isBefore(start)) {
                throw new IllegalArgumentException("End date must be after start date");
            }

            return runRepository.findByStartedOnBetween(start, end);
        }

    }