package com.dario.webapp.backend.demo.todo.services;

import com.dario.webapp.backend.demo.todo.model.Task;
import com.dario.webapp.backend.demo.todo.model.TaskDTO;
import com.dario.webapp.backend.demo.todo.repositories.TaskRepository;
import liquibase.repackaged.org.apache.commons.lang3.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public Task findById(Long taskId){
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id " + taskId + " not found.");
        }
        return task;
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task createTask(TaskDTO taskDTO) {
        Validate.notNull(taskDTO);
        //
        return taskRepository.save(taskDTO.toTask());
    }

    @Transactional
    public Task updateTask(Long taskId, TaskDTO taskDTO) {
        Validate.notNull(taskDTO);
        Validate.notNull(taskId);
        //
        Task task = findById(taskId);
        task.setText(taskDTO.getText());
        return taskRepository.save(task);
    }

    @Transactional
    public Task deleteTask(Long taskId) {
        Validate.notNull(taskId);
        //
        Task task = findById(taskId);
        taskRepository.delete(task);
        return task;
    }
}
