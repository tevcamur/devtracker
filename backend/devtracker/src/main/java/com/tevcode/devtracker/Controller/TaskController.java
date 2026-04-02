package com.tevcode.devtracker.Controller;

import com.tevcode.devtracker.model.Task;
import com.tevcode.devtracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DevTracker REST Controller
 *
 * Verwerkt HTTP requests voor tasks.
 * Biedt endpoints om taken op te halen, aan te maken, te updaten en te verwijderen.
 * Communiceert met TaskService voor business logic.
 */
@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Task create(@Valid @RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @Valid @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}