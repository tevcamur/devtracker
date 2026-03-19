package com.tevcode.devtracker.service;



import com.tevcode.devtracker.model.Task;
import com.tevcode.devtracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DevTracker Service
 *
 * Deze service beheert developer tasks in de applicatie DevTracker.
 * Taken kunnen worden aangemaakt, geüpdatet, opgehaald of verwijderd.
 * Hier worden ook automatisch timestamps toegevoegd bij nieuwe taken.
 *
 * Deze laag scheidt business logic van database en REST API.
 */
@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return repo.save(task);
    }

    public Task update(Long id, Task updated) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Oepssss, task not found.."));

        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        task.setStatus(updated.getStatus());
        task.setType(updated.getType());
        task.setPriority(updated.getPriority());

        return repo.save(task);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
