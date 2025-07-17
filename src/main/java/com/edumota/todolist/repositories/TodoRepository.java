package com.edumota.todolist.repositories;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.enums.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTitleContainingIgnoreCase(String title);

    List<Todo> findByPriority(Priority priority);
}
