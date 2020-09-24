package com.manuelsch.simplekanban.DTOs.board;

import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.PropertyValidationException;

public class UpdateBoardRequest implements Request {

    private String id;

    private String title;

    public String getId() {
        return id;
    }

    public UpdateBoardRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UpdateBoardRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public void validate() throws InputValidationException {
        try {
            Board.validateId(getId());
            Board.validateTitle(getTitle());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }
}
