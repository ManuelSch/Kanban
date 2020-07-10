package com.manuelsch.simplekanban.DTOs.boardColumn;

import com.manuelsch.simplekanban.models.BoardColumn;

public class CreateBoardColumnResponse {

    private String id;

    private String title;

    private Integer position;

    public CreateBoardColumnResponse(BoardColumn boardColumn) {
        setId(boardColumn.getId());
        setTitle(boardColumn.getTitle());
        setPosition(boardColumn.getPosition());
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
