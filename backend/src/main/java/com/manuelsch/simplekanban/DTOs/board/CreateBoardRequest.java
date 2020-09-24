package com.manuelsch.simplekanban.DTOs.board;

import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.PropertyValidationException;

public class CreateBoardRequest implements Request {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void validate() throws InputValidationException {
        try {
            Board.validateTitle(getTitle());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }
}
