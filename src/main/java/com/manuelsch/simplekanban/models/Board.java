package com.manuelsch.simplekanban.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Board {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    private Collection<BoardColumn> columns = new ArrayList<>();


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

    public Collection<BoardColumn> getColumns() {
        return columns;
    }

    public void setColumns(Collection<BoardColumn> columns) {
        this.columns = columns;
    }
}
