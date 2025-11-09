package com.gabriel.taskManager.TaskManager.infrastructure.persistence.entity;

import com.gabriel.taskManager.TaskManager.domain.ValueObjects.Description;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity
public class TaskPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Description description;
    private LocalDate dueDate;
    private boolean completed;

    public TaskPersistenceEntity(Long id, String title, Description description, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public TaskPersistenceEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
