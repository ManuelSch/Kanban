package com.manuelsch.simplekanban.DTOs.board;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.PropertyValidationException;

import java.io.Serializable;

public class CreateBoardRequest implements Serializable {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void validate() throws InputValidationException {
        try {
            Board.validateTitle(getTitle());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }
}
