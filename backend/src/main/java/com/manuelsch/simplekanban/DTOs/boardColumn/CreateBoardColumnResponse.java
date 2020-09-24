package com.manuelsch.simplekanban.DTOs.boardColumn;

import com.manuelsch.simplekanban.DTOs.Response;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;

import java.util.Set;

public class CreateBoardColumnResponse implements Response {

    private String id;

    private String title;

    private Set<BoardColumn> columns;

    public CreateBoardColumnResponse(Board board) {
        setId(board.getId());
        setTitle(board.getTitle());
        setColumns(board.getColumns());
    }

    public String getId() {
        return id;
    }

    public CreateBoardColumnResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateBoardColumnResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public Set<BoardColumn> getColumns() {
        return columns;
    }

    public CreateBoardColumnResponse setColumns(Set<BoardColumn> columns) {
        this.columns = columns;
        return this;
    }
}
