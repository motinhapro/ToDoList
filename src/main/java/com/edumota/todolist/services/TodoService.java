package com.edumota.todolist.services;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.repositories.TodoRepository;
import com.edumota.todolist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo with id " + id + " not found"));
    }
}
