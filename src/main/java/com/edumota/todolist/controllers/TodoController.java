package com.edumota.todolist.controllers;

import com.edumota.todolist.dto.TodoDTO;
import com.edumota.todolist.dto.TodoPostDTO;
import com.edumota.todolist.dto.TodoUpdateDTO;
import com.edumota.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Long id, @RequestBody TodoUpdateDTO todo) {
        return ResponseEntity.ok().body(new TodoDTO(service.update(id, todo)));
    }

    @PostMapping
    public ResponseEntity<TodoDTO> insert(@RequestBody TodoPostDTO todo) {
        return ResponseEntity.ok().body(new TodoDTO(service.insert(todo)));
    }
}
