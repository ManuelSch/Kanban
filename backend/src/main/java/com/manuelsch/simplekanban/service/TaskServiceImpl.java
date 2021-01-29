package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.Task;
import com.manuelsch.simplekanban.repositories.BoardColumnRepository;
import com.manuelsch.simplekanban.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    BoardColumnRepository boardColumnRepository;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository, BoardColumnRepository boardColumnRepository) {
        this.taskRepository = taskRepository;
        this.boardColumnRepository = boardColumnRepository;
    }

    @Override
    @Transactional
    public Task createTask(String boardColumnId, String title) throws RecordNotFoundException {
        BoardColumn boardColumn = boardColumnRepository.findById(boardColumnId)
                .orElseThrow(() -> new RecordNotFoundException("No boardColumn with the given ID could be found."));

        Task newTask = new Task()
                .setTitle(title)
                .setPosition(boardColumn.getTasks().size())
                .setPriority(Priority.MEDIUM)
                .setDescription("");

        Task createdTask = taskRepository.save(newTask);

        boardColumn.getTasks().add(createdTask);
        createdTask.setBoardColumn(boardColumn);

        return taskRepository.save(createdTask);
    }

    @Override
    @Transactional
    public Task updateTask(String id, String boardColumnId, String title, Integer position, Priority priority, String color, String description) throws RecordNotFoundException {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No task with the given ID could be found."));

        if (title != null)
            existingTask.setTitle(title);

        if (boardColumnId != null) {
            BoardColumn oldBoardColumn = existingTask.getBoardColumn();
            oldBoardColumn.getTasks().remove(existingTask);
            boardColumnRepository.save(oldBoardColumn);
            BoardColumn newBoardColumn = boardColumnRepository.findById(boardColumnId)
                    .orElseThrow(() -> new RecordNotFoundException("No boardColumn with the given ID could be found."));
            newBoardColumn.getTasks().add(existingTask);
            existingTask.setBoardColumn(newBoardColumn);
        }

        if (position != null)
            existingTask.setPosition(position);

        if (priority != null)
            existingTask.setPriority(priority);

        if (color != null)
            existingTask.setColor(color);

        if (description != null)
            existingTask.setDescription(description);

        return taskRepository.save(existingTask);
    }

}
