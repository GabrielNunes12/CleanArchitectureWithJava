package com.gabriel.taskManager.TaskManager.application.usecase;

import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.domain.repository.TaskRepository;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskInput;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Void execute(TaskInput task) {
        taskRepository.deleteById(task.id());
        return null;
    }
}
