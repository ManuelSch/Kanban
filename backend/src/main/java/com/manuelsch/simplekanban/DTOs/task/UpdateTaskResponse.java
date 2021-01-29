package com.manuelsch.simplekanban.DTOs.task;

import com.manuelsch.simplekanban.DTOs.Response;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.Task;

public class UpdateTaskResponse implements Response {

    private String id;

    private String title;

    private Integer position;

    private Priority priority;

    private String color;

    private String description;

    public UpdateTaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.position = task.getPosition();
        this.priority = task.getPriority();
        this.color = task.getColor();
        this.description = task.getDescription();
    }

    public String getId() {
        return id;
    }

    public UpdateTaskResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UpdateTaskResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public UpdateTaskResponse setPosition(Integer position) {
        this.position = position;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public UpdateTaskResponse setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public String getColor() {
        return color;
    }

    public UpdateTaskResponse setColor(String color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UpdateTaskResponse setDescription(String description) {
        this.description = description;
        return this;
    }
}
