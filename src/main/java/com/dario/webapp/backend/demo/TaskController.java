package com.dario.webapp.backend.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Task updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskId, taskDTO);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Task deleteTask(@PathVariable("id") Long taskId) {
        return taskService.deleteTask(taskId);
    }

}
