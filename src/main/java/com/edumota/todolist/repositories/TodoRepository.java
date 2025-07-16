package com.edumota.todolist.repositories;

import com.edumota.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
