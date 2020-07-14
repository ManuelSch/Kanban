package com.manuelsch.simplekanban.models;

/**
 * A Kanban task/item
 */
public class Task {

    private String title;

    private Priority priority;

    private String color;

    private String description;


    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Task setColor(String color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }
}
