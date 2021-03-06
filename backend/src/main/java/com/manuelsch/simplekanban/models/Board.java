package com.manuelsch.simplekanban.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "board")
    @JsonManagedReference
    private Set<BoardColumn> columns = new HashSet<>();


    public Optional<BoardColumn> getColumnAtPosition(Integer position) {
        return getColumns().stream().filter(col -> col.getPosition().equals(position)).findFirst();
    }

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

    public Board setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Board setTitle(String title) {
        this.title = title;
        return this;
    }

    public Set<BoardColumn> getColumns() {
        return columns;
    }

    public Board setColumns(Set<BoardColumn> columns) {
        this.columns = columns;
        return this;
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
                ", columns=" + columns.stream().map(BoardColumn::getId).collect(Collectors.joining()) +
                '}';
    }
}
