package com.tevcode.devtracker.repository;

import com.tevcode.devtracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
