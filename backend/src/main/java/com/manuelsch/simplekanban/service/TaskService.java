package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Priority;
import com.manuelsch.simplekanban.models.Task;

public interface TaskService {

    Task createTask(String boardColumnId, String title) throws RecordNotFoundException;

    Task updateTask(String id, String title, Priority priority, String color, String description) throws RecordNotFoundException;
}
