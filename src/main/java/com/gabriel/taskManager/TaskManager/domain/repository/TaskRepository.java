package com.gabriel.taskManager.TaskManager.domain.repository;


import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskOutput;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    TaskOutput save(Task task);
    List<TaskOutput> findAll();
    Optional<TaskOutput> findById(Long id);
    void deleteById(Long id);
}
