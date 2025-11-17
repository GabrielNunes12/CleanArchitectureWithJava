package com.gabriel.taskManager.TaskManager.domain.events.shared;

public interface EventHandlerInterface<T extends EventInterface<T>> {
    void handle(T event);
}
