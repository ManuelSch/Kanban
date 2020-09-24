package com.manuelsch.simplekanban.DTOs.board;

import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;

import java.io.Serializable;
import java.util.List;

public class UpdateBoardResponse implements Serializable {

    private String id;

    private String title;

    private List<BoardColumn> columns;

    public UpdateBoardResponse(Board board) {
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

    public List<BoardColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<BoardColumn> columns) {
        this.columns = columns;
    }

}
