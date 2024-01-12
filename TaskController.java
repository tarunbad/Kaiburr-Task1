package com.example.taskapi.controller;

import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    // GET all tasks or a specific task by ID
    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            return List.of(taskRepository.findById(id).orElse(null));
        }
        return taskRepository.findAll();
    }

    // PUT a task
    @PutMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // DELETE a task by ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
    }

    // GET tasks by name
    @GetMapping("/findByName/{name}")
    public List<Task> findTasksByName(@PathVariable String name) {
        return taskRepository.findByNameContaining(name);
    }

    // GET first 10 tasks by assignee, sorted by startTime
    @GetMapping("/findByAssignee/{assignee}")
    public List<Task> findTasksByAssignee(@PathVariable String assignee) {
        return taskRepository.findByAssigneeOrderByStartTime(assignee);
    }
}
