package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.DTOs.SuccessResponse;
import com.manuelsch.simplekanban.DTOs.boardColumn.CreateBoardColumnRequest;
import com.manuelsch.simplekanban.DTOs.boardColumn.CreateBoardColumnResponse;
import com.manuelsch.simplekanban.DTOs.boardColumn.UpdateBoardColumnRequest;
import com.manuelsch.simplekanban.DTOs.boardColumn.UpdateBoardColumnResponse;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.service.BoardColumnService;
import com.manuelsch.simplekanban.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API endpoint for Kanban board columns
 */
@RestController
@RequestMapping("/api/boardColumn")
public class BoardColumnController {

    BoardColumnService boardColumnService;
    BoardService boardService;

    public BoardColumnController(BoardColumnService boardColumnService, BoardService boardService) {
        this.boardColumnService = boardColumnService;
        this.boardService = boardService;
    }

    @PostMapping
    public SuccessResponse<CreateBoardColumnResponse> createBoardColumn(@RequestBody CreateBoardColumnRequest newBoardColumn) throws InputValidationException, RecordNotFoundException {
        newBoardColumn.validate();
        BoardColumn createdColumn = boardColumnService.createColumn(newBoardColumn.getTitle(), newBoardColumn.getBoardId());
        return new SuccessResponse<>(new CreateBoardColumnResponse(createdColumn.getBoard()));
    }

    @PostMapping("/update")
    public SuccessResponse<UpdateBoardColumnResponse> updateBoardColumn(@RequestBody UpdateBoardColumnRequest updatedColumnData) throws InputValidationException, RecordNotFoundException {
        updatedColumnData.validate();
        BoardColumn updatedColumn = boardColumnService.updateColumn(updatedColumnData.getId(), updatedColumnData.getTitle(), updatedColumnData.getPosition());
        return new SuccessResponse<>(new UpdateBoardColumnResponse(updatedColumn));
    }
}
