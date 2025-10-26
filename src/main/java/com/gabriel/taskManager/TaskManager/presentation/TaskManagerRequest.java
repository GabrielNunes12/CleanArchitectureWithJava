package com.gabriel.taskManager.TaskManager.presentation;

import com.gabriel.taskManager.TaskManager.application.usecase.CreateTaskUseCase;
import com.gabriel.taskManager.TaskManager.application.usecase.DeleteTaskUseCase;
import com.gabriel.taskManager.TaskManager.application.usecase.ListAllTasksUseCase;
import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskInput;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskManagerRequest {
    private final CreateTaskUseCase createTaskUseCase;
    private final ListAllTasksUseCase getAllTasksUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    public TaskManagerRequest(CreateTaskUseCase createTaskUseCase, ListAllTasksUseCase getAllTasksUseCase, DeleteTaskUseCase deleteTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getAllTasksUseCase = getAllTasksUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @GetMapping
    public ResponseEntity<List<TaskOutput>> getAllTasks() {
        return ResponseEntity.ok(getAllTasksUseCase.execute());
    }

    @PostMapping
    public ResponseEntity<TaskOutput> create(@RequestBody TaskInput taskBody) {
        return ResponseEntity.ok(createTaskUseCase
                .execute(taskBody.title(), taskBody.description(), taskBody.dueDate()));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody TaskInput task) {
        return ResponseEntity.ok(deleteTaskUseCase.execute(task));
    }

}
