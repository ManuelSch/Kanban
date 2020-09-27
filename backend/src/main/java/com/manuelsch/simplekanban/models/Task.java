package com.manuelsch.simplekanban.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A Kanban task/item
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String title;

    @Column
    private Priority priority;

    @Column
    private String color;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private BoardColumn boardColumn;


    /**
     * Checks if the given value is a valid Task title
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validateTitle(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No title given");
        if (!(val instanceof String))
            throw new PropertyValidationException("Title must be a string");
        String title = (String) val;
        if (title.length() <= 0)
            throw new PropertyValidationException("Title must not be empty");
        if (title.length() > 255)
            throw new PropertyValidationException("Title must be shorter than 256 characters");
    }


    public String getId() {
        return id;
    }

    public Task setId(String id) {
        this.id = id;
        return this;
    }

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

    public BoardColumn getBoardColumn() {
        return boardColumn;
    }

    public Task setBoardColumn(BoardColumn boardColumn) {
        this.boardColumn = boardColumn;
        return this;
    }
}
