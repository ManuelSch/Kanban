package com.manuelsch.simplekanban.DTOs.board;

import com.manuelsch.simplekanban.DTOs.Response;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;

import java.util.Set;

public class CreateBoardResponse implements Response {

    private String id;

    private String title;

    private Set<BoardColumn> columns;

    public CreateBoardResponse(Board board) {
        setId(board.getId());
        setTitle(board.getTitle());
        setColumns(board.getColumns());
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

    public Set<BoardColumn> getColumns() {
        return columns;
    }

    public void setColumns(Set<BoardColumn> columns) {
        this.columns = columns;
    }
}
