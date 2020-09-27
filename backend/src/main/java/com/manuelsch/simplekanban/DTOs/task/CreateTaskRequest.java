package com.manuelsch.simplekanban.DTOs.task;


import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.models.PropertyValidationException;
import com.manuelsch.simplekanban.models.Task;

public class CreateTaskRequest implements Request {

    String boardColumnId;

    String title;

    @Override
    public void validate() throws InputValidationException {
        try {
            BoardColumn.validateId(getBoardColumnId());
            Task.validateTitle(getTitle());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }

    public String getBoardColumnId() {
        return boardColumnId;
    }

    public CreateTaskRequest setBoardColumnId(String boardColumnId) {
        this.boardColumnId = boardColumnId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateTaskRequest setTitle(String title) {
        this.title = title;
        return this;
    }
}
