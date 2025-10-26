package com.gabriel.taskManager.TaskManager.application.mapper;

import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.infrastructure.persistence.entity.TaskPersistenceEntity;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskInput;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskOutput;

public class TaskMapper {
    //domain <-> persistence
    public static TaskPersistenceEntity toEntity(Task task) {
        return new TaskPersistenceEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
    }

    public static TaskOutput toDomain(TaskPersistenceEntity taskPersistenceEntity) {
        return new TaskOutput(
                taskPersistenceEntity.getId(),
                taskPersistenceEntity.getTitle(),
                taskPersistenceEntity.getDescription(),
                taskPersistenceEntity.getDueDate(),
                taskPersistenceEntity.isCompleted()
        );
    }

    //domain <-> dto
    public static Task toDomain(TaskInput taskInput) {
        return new Task(
                null,
                taskInput.title(),
                taskInput.description(),
                taskInput.dueDate(),
                taskInput.isCompleted()
        );
    }
    public static TaskOutput toResponse(Task task) {
        return new TaskOutput(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
    }
}
