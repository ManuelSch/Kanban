package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.repositories.BoardRepository;
import com.manuelsch.simplekanban.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board newBoard) {
        assert newBoard.getTitle() != null : "Title is null";
        assert newBoard.getTitle().length() < 255 : "Title must be shorter than 255 characters";

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
