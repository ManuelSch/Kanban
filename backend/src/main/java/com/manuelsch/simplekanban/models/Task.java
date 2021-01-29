package com.manuelsch.simplekanban.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

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
    private Integer position;

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
     * Checks if the given value is a valid Task id
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validateId(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No ID given");
        if (!(val instanceof String))
            throw new PropertyValidationException("ID must be a string");
        String id = (String) val;
        if (id.length() > 255)
            throw new PropertyValidationException("ID must be a valid UUID");
    }

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

    /**
     * Checks if the given value is a valid Task position
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validatePosition(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No position given");
        if (!(val instanceof Integer))
            throw new PropertyValidationException("Position must be an integer");
        Integer position = (Integer) val;
        if (position < 0)
            throw new PropertyValidationException("Position must not be negative");
    }

    /**
     * Checks if the given value is a valid Task priority
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validatePriority(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No priority given");
        if (!(val instanceof Priority))
            throw new PropertyValidationException("Priority must be one of the following strings: " + Arrays.toString(Priority.values()));
    }

    /**
     * Checks if the given value is a valid Task color
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validateColor(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No color given");
        if (!(val instanceof String))
            throw new PropertyValidationException("Color must be a string");
        String color = (String) val;
        if (color.length() <= 0)
            throw new PropertyValidationException("Color must not be empty");
        if (color.length() > 16)
            throw new PropertyValidationException("Color must be shorter than 16 characters");
    }


    /**
     * Checks if the given value is a valid Task description
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validateDescription(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No description given");
        if (!(val instanceof String))
            throw new PropertyValidationException("Description must be a string");
        String description = (String) val;
        if (description.length() > 1024)
            throw new PropertyValidationException("Description must be shorter than 1024 characters");
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", priority=" + priority +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", boardColumn=" + boardColumn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Integer getPosition() {
        return position;
    }

    public Task setPosition(Integer position) {
        this.position = position;
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
