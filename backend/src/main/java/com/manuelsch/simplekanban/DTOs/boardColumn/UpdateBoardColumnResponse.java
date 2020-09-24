package com.manuelsch.simplekanban.DTOs.boardColumn;

import com.manuelsch.simplekanban.DTOs.Response;
import com.manuelsch.simplekanban.models.BoardColumn;

public class UpdateBoardColumnResponse implements Response {

    private String id;

    private String title;

    private Integer position;

    public UpdateBoardColumnResponse(BoardColumn column) {
        this.id = column.getId();
        this.title = column.getTitle();
        this.position = column.getPosition();
    }

    public String getId() {
        return id;
    }

    public UpdateBoardColumnResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UpdateBoardColumnResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public UpdateBoardColumnResponse setPosition(Integer position) {
        this.position = position;
        return this;
    }
}
