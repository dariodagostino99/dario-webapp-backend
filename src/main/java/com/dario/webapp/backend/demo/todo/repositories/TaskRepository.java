package com.dario.webapp.backend.demo.todo.repositories;

import com.dario.webapp.backend.demo.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
