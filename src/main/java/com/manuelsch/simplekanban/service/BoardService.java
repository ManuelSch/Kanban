package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.models.Board;

public interface BoardService {

    /**
     * Creates a new Kanban board
     * @param newBoard
     * @return
     */
    public Board createBoard(Board newBoard);

    /**
     * Returns the Kanban board with the given ID
     * @param id
     * @return
     */
    public Board getBoardById(String id);

    /**
     * Returns all Kanban boards stored in the database
     * @return
     */
    public Board getAllBoards();

}
