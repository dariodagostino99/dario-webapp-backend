package com.dario.webapp.backend.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private Long id;

    private String text;

    public Task toTask() {
        return Task.builder().text(getText()).build();
    }
}
