package com.gabriel.taskManager.TaskManager.presentation.dto;

import com.gabriel.taskManager.TaskManager.domain.ValueObjects.Description;

import java.time.LocalDate;

public record TaskOutput(Long id, String title, Description description, LocalDate dueDate, boolean isCompleted) { }
