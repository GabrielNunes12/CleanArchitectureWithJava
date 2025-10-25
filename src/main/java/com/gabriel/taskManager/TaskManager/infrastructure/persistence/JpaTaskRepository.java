package com.gabriel.taskManager.TaskManager.infrastructure.persistence;

import com.gabriel.taskManager.TaskManager.infrastructure.persistence.entity.TaskPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskPersistenceEntity, Long> {
}
