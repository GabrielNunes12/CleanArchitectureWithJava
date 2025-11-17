package com.gabriel.taskManager.TaskManager.domain.events.shared;

import java.util.Date;

public interface EventInterface<T> {
    Date occurredOn();
    T event();
}
