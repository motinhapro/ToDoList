package com.edumota.todolist.controllers;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.dto.TodoDTO;
import com.edumota.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<TodoDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(TodoDTO::new).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TodoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new TodoDTO(service.findById(id)));
    }
}
