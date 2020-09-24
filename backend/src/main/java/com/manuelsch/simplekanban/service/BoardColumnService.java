package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.BoardColumn;

import javax.persistence.EntityNotFoundException;

/**
 * Business logic for dealing with Kanban board columns
 */
public interface BoardColumnService {

    /**
     * Adds a new column to an existing Kanban board
     *
     * @param title
     * @param boardId
     * @return
     */
    BoardColumn createColumn(String title, String boardId) throws RecordNotFoundException;

    /**
     * Updates the column with the given data
     *
     * @param id
     * @param title
     * @param position
     * @return
     * @throws RecordNotFoundException
     */
    BoardColumn updateColumn(String id, String title, Integer position) throws RecordNotFoundException;
}
