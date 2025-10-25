package com.gabriel.taskManager.TaskManager.infrastructure.persistence;

import com.gabriel.taskManager.TaskManager.application.mapper.TaskMapper;
import com.gabriel.taskManager.TaskManager.domain.entity.Task;
import com.gabriel.taskManager.TaskManager.domain.repository.TaskRepository;
import com.gabriel.taskManager.TaskManager.infrastructure.persistence.entity.TaskPersistenceEntity;
import com.gabriel.taskManager.TaskManager.presentation.dto.TaskOutput;
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
    public TaskOutput save(Task task) {
        TaskPersistenceEntity saved = jpaTaskRepository.save(TaskMapper.toEntity(task));
        return TaskMapper.toDomain(saved);
    }

    @Override
    public List<TaskOutput> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<TaskOutput> findById(Long id) {
        return jpaTaskRepository
                .findById(id)
                .map(TaskMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRepository.deleteById(id);
    }
}
