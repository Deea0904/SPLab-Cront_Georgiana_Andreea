package com.example.labsp.controllers;

import com.example.labsp.commands.TaskRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TasksController {

    private final TaskRegistry tasks;

    public TasksController(TaskRegistry tasks) {
        this.tasks = tasks;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Map<String, Object>> status(@PathVariable String id) {
        Map<String, Object> status = tasks.status(id);
        return status == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(status);
    }
}