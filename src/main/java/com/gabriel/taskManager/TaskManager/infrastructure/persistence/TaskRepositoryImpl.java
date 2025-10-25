package com.gabriel.taskManager.TaskManager.infrastructure.persistence;

import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.domain.repository.TaskRepository;
import com.gabriel.taskManager.TaskManager.infrastructure.persistence.entity.TaskPersistenceEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryImpl implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;

    public TaskRepositoryImpl(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskPersistenceEntity entity = new TaskPersistenceEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
        TaskPersistenceEntity saved = jpaTaskRepository.save(entity);
        return new Task(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getDueDate(), saved.isCompleted());
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(e -> new Task(e.getId(), e.getTitle(), e.getDescription(), e.getDueDate(), e.isCompleted()))
                .toList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository
                .findById(id)
                .map(e -> new Task(e.getId(), e.getTitle(), e.getDescription(), e.getDueDate(), e.isCompleted()));
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRepository.deleteById(id);
    }
}
