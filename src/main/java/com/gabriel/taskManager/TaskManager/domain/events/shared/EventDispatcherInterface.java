package com.gabriel.taskManager.TaskManager.domain.events.shared;

public interface EventDispatcherInterface {
    void notify(EventInterface eventInterface);
    void register(String eventName, EventHandlerInterface eventHandler);
    void unregister(String eventName, EventHandlerInterface eventHandler);
}
