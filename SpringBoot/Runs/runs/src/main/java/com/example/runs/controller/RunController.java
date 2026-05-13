package com.example.runs.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/runs")  
public class RunController {

    // Dati in memoria (simulazione, verrà sostituito da DB al Giorno 5)
    private List<String> runs = new ArrayList<>(List.of("Run A", "Run B", "Run C"));

    // GET /api/runs → restituisce la lista completa
    @GetMapping
    public List<String> findAll() {
        return runs;
    }

    // GET /api/runs/{id} → restituisce un singolo elemento per indice
    @GetMapping("/{id}")
    public String findById(@PathVariable int id) {
        return runs.get(id);
    }

    // POST /api/runs → aggiunge un nuovo elemento
    // Il corpo della richiesta JSON viene deserializzato in una String
    @PostMapping
    public String create(@RequestBody String newRun) {
        runs.add(newRun);
        return newRun;
    }

    // PUT /api/runs/{id} → sostituisce un elemento esistente
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody String updatedRun) {
        runs.set(id, updatedRun);
        return updatedRun;
    }

    // DELETE /api/runs/{id} → elimina un elemento
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        runs.remove(id);
    }

    // GET /api/runs/search?keyword=Run → ricerca per query string
    @GetMapping("/search")
    public List<String> search(@RequestParam String keyword) {
        return runs.stream()
                   .filter(r -> r.contains(keyword))
                   .toList();
    }
}