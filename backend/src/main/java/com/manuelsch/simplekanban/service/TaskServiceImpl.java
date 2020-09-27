package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.BoardColumn;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.Task;
import com.manuelsch.simplekanban.repositories.BoardColumnRepository;
import com.manuelsch.simplekanban.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Task createTask(String boardColumnId, String title) throws RecordNotFoundException {
        BoardColumn boardColumn = boardColumnRepository.findById(boardColumnId)
                .orElseThrow(() -> new RecordNotFoundException("No boardColumn with the given ID could be found."));

        Task newTask = new Task()
                .setTitle(title)
                .setPriority(Priority.MEDIUM)
                .setDescription("");

        Task createdTask = taskRepository.save(newTask);

        boardColumn.getTasks().add(createdTask);
        BoardColumn updatedBoardColumn = boardColumnRepository.save(boardColumn);

//        newTask.setId(updatedBoardColumn.getTaskById(createdTask.getId()).)
//        newTask.setId(updatedBoardColumn.getTaskById(createdTask.getId()).)
        createdTask.setBoardColumn(updatedBoardColumn);

        return taskRepository.save(createdTask);
    }

}
