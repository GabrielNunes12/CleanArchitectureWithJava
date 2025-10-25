package com.gabriel.taskManager.TaskManager.application.usecase;

import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateTaskUseCase {
    private final TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(String title, String description, LocalDate localDate) {
        Task task = new Task(null, title, description, localDate, false);
        return taskRepository.save(task);
    }
}
