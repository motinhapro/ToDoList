package com.edumota.todolist.services;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }
}
