package com.gabriel.taskManager.TaskManager.domain.repository;


import com.gabriel.taskManager.TaskManager.domain.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    Optional<Task> findById(Long id);
    void deleteById(Long id);
}
