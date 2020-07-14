package com.manuelsch.simplekanban.controllers;

import com.manuelsch.simplekanban.models.Task;
import org.springframework.web.bind.annotation.*;

/**
 * REST API endpoint for Kanban tasks
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @PostMapping
    public void create(@RequestBody Task newTask) {
        System.out.println("New Request: POST /api/task");
    }

}
