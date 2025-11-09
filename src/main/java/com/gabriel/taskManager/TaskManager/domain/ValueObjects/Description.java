package com.gabriel.taskManager.TaskManager.domain.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Description(String description) {

    private static final int MAX_LENGTH = 250;
    private static final int MIN_LENGTH = 10;

    public Description {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        if (description.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Description must be at least " + MIN_LENGTH + " characters long");
        }

        if (description.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Description must be at most " + MAX_LENGTH + " characters long");
        }
    }

    public static Description of(String description) {
        return new Description(description);
    }
}
