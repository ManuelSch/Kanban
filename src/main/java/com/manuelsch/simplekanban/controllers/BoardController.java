package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
