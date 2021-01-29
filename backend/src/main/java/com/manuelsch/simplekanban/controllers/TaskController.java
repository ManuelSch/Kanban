package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.DTOs.SuccessResponse;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;
import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.DTOs.task.CreateTaskRequest;
import com.manuelsch.simplekanban.DTOs.task.CreateTaskResponse;
import com.manuelsch.simplekanban.DTOs.task.UpdateTaskRequest;
import com.manuelsch.simplekanban.DTOs.task.UpdateTaskResponse;
import com.manuelsch.simplekanban.models.Task;
import com.manuelsch.simplekanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API endpoint for Kanban tasks
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public SuccessResponse<CreateTaskResponse> createTask(@RequestBody CreateTaskRequest newTask) throws InputValidationException, RecordNotFoundException {
        newTask.validate();
        Task createdTask = taskService.createTask(newTask.getBoardColumnId(), newTask.getTitle());
        return new SuccessResponse<>(new CreateTaskResponse(createdTask));
    }

    @PostMapping("/update")
    public SuccessResponse<UpdateTaskResponse> updateTask(@RequestBody UpdateTaskRequest updatedTaskData) throws InputValidationException, RecordNotFoundException {
        updatedTaskData.validate();
        Task updatedTask = taskService.updateTask(
                updatedTaskData.getId(),
                updatedTaskData.getBoardColumnId(),
                updatedTaskData.getTitle(),
                updatedTaskData.getPosition(),
                updatedTaskData.getPriority(),
                updatedTaskData.getColor(),
                updatedTaskData.getDescription()
        );
        return new SuccessResponse<>(new UpdateTaskResponse(updatedTask));
    }

}
