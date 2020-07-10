package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.DTOs.SuccessResponse;
import com.manuelsch.simplekanban.DTOs.board.CreateBoardRequest;
import com.manuelsch.simplekanban.DTOs.board.CreateBoardResponse;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.models.Board;
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
    public SuccessResponse<CreateBoardResponse> createBoard(@RequestBody CreateBoardRequest newBoard) throws InputValidationException, RecordNotFoundException {
        newBoard.validate();
        Board createdBoard = boardService.createBoard(newBoard.getTitle());
        return new SuccessResponse<>(new CreateBoardResponse(createdBoard));
    }

    @GetMapping
    public Board getBoardById(@RequestParam("id") String id) {
        return boardService.getBoardById(id).orElse(null);
    }

    @RequestMapping("/all")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }
}
