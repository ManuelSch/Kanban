package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.repositories.BoardColumnRepository;
import com.manuelsch.simplekanban.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardColumnServiceImpl implements BoardColumnService {

    BoardRepository boardRepository;
    BoardColumnRepository columnRepository;

    @Autowired
    public BoardColumnServiceImpl(BoardRepository boardRepository, BoardColumnRepository columnRepository) {
        this.boardRepository = boardRepository;
        this.columnRepository = columnRepository;
    }

    @Override
    @Transactional
    public BoardColumn createColumn(String title, String boardId) throws RecordNotFoundException {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RecordNotFoundException("No board with the given boardId could be found."));

        BoardColumn newBoardColumn = new BoardColumn()
                .setTitle(title)
                .setPosition(board.getColumns().size());

        board.getColumns().add(newBoardColumn);

        boardRepository.save(board);

        return newBoardColumn;
    }

    @Override
    @Transactional
    public BoardColumn updateColumn(String id, String title, Integer position) throws RecordNotFoundException {
        BoardColumn column = columnRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No boardColumn with the given ID could be found"));

        if(title != null)
            column.setTitle(title);

        if(position != null)
            column.setPosition(position);

        return columnRepository.save(column);
    }

}
