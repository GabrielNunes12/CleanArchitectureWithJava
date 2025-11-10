package com.gabriel.taskManager.TaskManager.domain.ValueObjects;

public record Name(String name) {
    public Name(String name) {
        if(name == null && name.length() < 4) {
            throw new IllegalArgumentException("Name should not be null");
        }
        this.name = name;
    }
}
