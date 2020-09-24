package com.manuelsch.simplekanban.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * A single column of a Kanban board
 */
@Entity
public class BoardColumn {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String title;

    @Column
    private Integer position;

    /**
     * Checks if the given value is a valid BoardColumn id
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
     * Checks if the given value is a valid BoardColumn title
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
     * Checks if the given value is a valid BoardColumn position
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

    public String getId() {
        return id;
    }

    public BoardColumn setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BoardColumn setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public BoardColumn setPosition(Integer position) {
        this.position = position;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardColumn that = (BoardColumn) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BoardColumn{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", position=" + position +
                '}';
    }
}
