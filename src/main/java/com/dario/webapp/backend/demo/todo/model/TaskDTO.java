package com.dario.webapp.backend.demo.todo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private String text;

    public Task toTask() {
        return Task.builder().text(getText()).build();
    }
}
