package com.manuelsch.simplekanban.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Kanban board
 */
@Entity
public class Board {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardColumn> columns = new ArrayList<>();


    /**
     * Checks if the given value is a valid Board id
     *
     * @param val
     * @throws PropertyValidationException
     */
    public static void validateId(Object val) throws PropertyValidationException {
        if (val == null)
            throw new PropertyValidationException("No boardId given");
        if (!(val instanceof String))
            throw new PropertyValidationException("BoardId must be a string");
        String id = (String) val;
        if (id.length() > 255)
            throw new PropertyValidationException("BoardId must be a valid UUID");
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BoardColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<BoardColumn> columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", columns=" + columns +
                '}';
    }
}
