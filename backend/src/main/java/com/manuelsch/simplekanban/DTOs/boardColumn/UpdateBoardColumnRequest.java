package com.manuelsch.simplekanban.DTOs.boardColumn;

import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.models.PropertyValidationException;

public class UpdateBoardColumnRequest implements Request {

    private String id;

    private String title;

    private Integer position;

    public String getId() {
        return id;
    }

    public UpdateBoardColumnRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UpdateBoardColumnRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public UpdateBoardColumnRequest setPosition(Integer position) {
        this.position = position;
        return this;
    }

    @Override
    public void validate() throws InputValidationException {
        try {
            BoardColumn.validateId(getId());
            if (getTitle() != null)
                BoardColumn.validateTitle(getTitle());
            if (getPosition() != null)
                BoardColumn.validatePosition(getPosition());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }
}
