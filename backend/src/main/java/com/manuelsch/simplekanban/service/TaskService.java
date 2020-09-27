package com.manuelsch.simplekanban.service;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.RecordNotFoundException;
import com.manuelsch.simplekanban.models.Task;

public interface TaskService {

    Task createTask(String boardColumnId, String title) throws RecordNotFoundException;

}
