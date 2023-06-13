package com.dario.webapp.backend.demo.todo.rest;

import com.dario.webapp.backend.demo.todo.model.TaskDTO;
import com.dario.webapp.backend.demo.todo.services.TaskService;
import com.dario.webapp.backend.demo.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById (@PathVariable("id") Long id){ return taskService.findById(id); }

    @PostMapping("")
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskId, taskDTO);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable("id") Long taskId) {
        return taskService.deleteTask(taskId);
    }

}
