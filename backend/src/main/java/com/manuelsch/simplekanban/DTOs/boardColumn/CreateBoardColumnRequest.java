package com.manuelsch.simplekanban.DTOs.boardColumn;

import com.manuelsch.simplekanban.DTOs.Request;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.models.PropertyValidationException;

public class CreateBoardColumnRequest implements Request {

    private String title;

    private String boardId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @Override
    public void validate() throws InputValidationException {
        try {
            Board.validateId(getBoardId());
            if (getTitle() != null)
                BoardColumn.validateTitle(getTitle());
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
    }
}
