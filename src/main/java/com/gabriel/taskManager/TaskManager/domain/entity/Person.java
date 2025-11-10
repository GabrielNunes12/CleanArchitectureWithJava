package com.gabriel.taskManager.TaskManager.domain.entity;

import com.gabriel.taskManager.TaskManager.domain.ValueObjects.Address;
import com.gabriel.taskManager.TaskManager.domain.ValueObjects.Identification;
import com.gabriel.taskManager.TaskManager.domain.ValueObjects.Name;

public class Person {
    private String idTask;
    private Name name;
    private Identification id;
    private Address address;

    public Person(Name name, Identification id, Address address, String idTask) {
        this.idTask = idTask;
        this.name = name;
        this.id = id;
        this.address = address;
    }
}
