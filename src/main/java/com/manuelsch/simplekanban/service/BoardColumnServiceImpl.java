package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class BoardColumnServiceImpl implements BoardColumnService {

    BoardRepository boardRepository;

    @Autowired
    public BoardColumnServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public BoardColumn createColumn(String title, String boardId) throws EntityNotFoundException, RecordNotFoundException {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RecordNotFoundException("No board with the given boardId could be found."));

        BoardColumn newBoardColumn = new BoardColumn();
        newBoardColumn.setTitle(title);
        newBoardColumn.setPosition(board.getColumns().size());

        board.getColumns().add(newBoardColumn);

        board = boardRepository.save(board);

        return board.getColumns().get(newBoardColumn.getPosition());
    }

}
