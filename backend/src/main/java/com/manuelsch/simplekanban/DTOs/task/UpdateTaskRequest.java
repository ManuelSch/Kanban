package com.manuelsch.simplekanban.DTOs.task;

import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.PropertyValidationException;
import com.manuelsch.simplekanban.models.Task;

public class UpdateTaskRequest implements Request {

    private String id;

    private String title;

    private Priority priority;

    private String color;

    private String description;

    @Override
    public void validate() throws InputValidationException {
        try {
            Task.validateId(getId());
            if (getTitle() != null)
                Task.validateTitle(getTitle());
            if (getPriority() != null)
                Task.validatePriority(getPriority());
            if (getColor() != null)
                Task.validateColor(getColor());
            if (getDescription() != null)
                Task.validateDescription(getDescription());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public UpdateTaskRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UpdateTaskRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public UpdateTaskRequest setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public String getColor() {
        return color;
    }

    public UpdateTaskRequest setColor(String color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UpdateTaskRequest setDescription(String description) {
        this.description = description;
        return this;
    }
}
