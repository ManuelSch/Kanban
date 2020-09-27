package com.manuelsch.simplekanban.DTOs.task;

import com.manuelsch.simplekanban.DTOs.Response;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.Task;

public class CreateTaskResponse implements Response {

    private String id;

    private String title;

    private Priority priority;

    private String color;

    private String description;

    public CreateTaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.priority = task.getPriority();
        this.color = task.getColor();
        this.description = task.getDescription();
    }

    public String getId() {
        return id;
    }

    public CreateTaskResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateTaskResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public CreateTaskResponse setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CreateTaskResponse setColor(String color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateTaskResponse setDescription(String description) {
        this.description = description;
        return this;
    }
}
