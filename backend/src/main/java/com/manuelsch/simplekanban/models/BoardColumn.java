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
     * Checks if the given value is a valid Board title
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
