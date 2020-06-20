package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Board createBoard(@RequestBody Board newBoard) {
        return boardService.createBoard(newBoard);
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
