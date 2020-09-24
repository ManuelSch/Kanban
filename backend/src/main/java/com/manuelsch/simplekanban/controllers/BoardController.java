package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.DTOs.SuccessResponse;
import com.manuelsch.simplekanban.DTOs.board.CreateBoardRequest;
import com.manuelsch.simplekanban.DTOs.board.CreateBoardResponse;
import com.manuelsch.simplekanban.DTOs.board.UpdateBoardRequest;
import com.manuelsch.simplekanban.DTOs.board.UpdateBoardResponse;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.PropertyValidationException;
import com.manuelsch.simplekanban.service.BoardService;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API endpoint for Kanban boards
 */
@RestController
@RequestMapping("/api/board")
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public SuccessResponse<CreateBoardResponse> createBoard(@RequestBody CreateBoardRequest newBoard) throws InputValidationException {
        newBoard.validate();
        Board createdBoard = boardService.createBoard(newBoard.getTitle());
        return new SuccessResponse<>(new CreateBoardResponse(createdBoard));
    }

    @GetMapping
    public SuccessResponse<Board> getBoardById(@RequestParam("id") String id)  throws InputValidationException, RecordNotFoundException {
        try {
            Board.validateId(id);
        } catch (PropertyValidationException e) {
            throw new InputValidationException(e.getMessage());
        }
        return new SuccessResponse<>(boardService.getBoardById(id));
    }

    @RequestMapping("/all")
    public SuccessResponse<List<Board>> getAllBoards() {
        return new SuccessResponse<>(boardService.getAllBoards());
    }

    @PostMapping("/update")
    public SuccessResponse<UpdateBoardResponse> updateBoard(@RequestBody UpdateBoardRequest updatedBoardData) throws InputValidationException, RecordNotFoundException {
        updatedBoardData.validate();
        Board updatedBoard = boardService.updateBoard(updatedBoardData.getId(), updatedBoardData.getTitle());
        return new SuccessResponse<>(new UpdateBoardResponse(updatedBoard));
    }

}
