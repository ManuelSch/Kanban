package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Board;

import java.util.List;

/**
 * Business logic for dealing with Kanban boards
 */
public interface BoardService {

    /**
     * Creates a new Kanban board
     *
     * @param title
     * @return
     * @throws AssertionError
     */
    Board createBoard(String title);

    /**
     * Returns the Kanban board with the given ID
     *
     * @param id
     * @return
     */
    Board getBoardById(String id) throws RecordNotFoundException;

    /**
     * Returns all Kanban boards stored in the database
     *
     * @return
     */
    List<Board> getAllBoards();

}
