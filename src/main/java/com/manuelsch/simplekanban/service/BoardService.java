package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.models.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    /**
     * Creates a new Kanban board
     * @param newBoard
     * @return
     */
    public Board createBoard(Board newBoard) throws AssertionError;

    /**
     * Returns the Kanban board with the given ID
     * @param id
     * @return
     */
    public Optional<Board> getBoardById(String id);

    /**
     * Returns all Kanban boards stored in the database
     * @return
     */
    public List<Board> getAllBoards();

}
