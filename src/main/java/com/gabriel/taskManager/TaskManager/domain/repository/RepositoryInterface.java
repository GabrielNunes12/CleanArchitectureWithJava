package com.gabriel.taskManager.TaskManager.domain.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<O, I> {
    O save(I task);
    List<O> findAll();
    Optional<O> findById(Long id);
    void deleteById(Long id);
}
