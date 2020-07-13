package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Board;
import com.manuelsch.simplekanban.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public Board createBoard(String title) {
        Board newBoard = new Board()
                .setTitle(title);

        return boardRepository.save(newBoard);
    }

    @Override
    public Optional<Board> getBoardById(String id) {
        return boardRepository.findById(id);
    }

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }


}
