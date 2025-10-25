package com.gabriel.taskManager.TaskManager.presentation.dto;

import java.time.LocalDate;

public record TaskOutput(Long id, String title, String description, LocalDate dueDate, boolean isCompleted) { }
