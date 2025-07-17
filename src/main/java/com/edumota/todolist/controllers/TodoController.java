package com.edumota.todolist.controllers;

import com.edumota.todolist.dto.TodoDTO;
import com.edumota.todolist.dto.TodoPostDTO;
import com.edumota.todolist.dto.TodoUpdateDTO;
import com.edumota.todolist.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<TodoDTO>> findByTitle(@RequestParam String title) {
       return ResponseEntity.ok().body(service.findByTitle(title).stream().map(TodoDTO::new).toList());
    }

    @GetMapping(value = "/priority")
    public ResponseEntity<List<TodoDTO>> findByPriority(@RequestParam String value) {
        return ResponseEntity.ok().body(service.findByPriority(value).stream().map(TodoDTO::new).toList());
    }

    @GetMapping(value = "/by-priority")
    public ResponseEntity<List<TodoDTO>> findAllByPriorityAsc(@RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok().body(service.findAllByPriority(direction).stream().map(TodoDTO::new).toList());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Long id,@Valid @RequestBody TodoUpdateDTO todo) {
        return ResponseEntity.ok().body(new TodoDTO(service.update(id, todo)));
    }

    @PostMapping
    public ResponseEntity<TodoDTO> insert(@Valid @RequestBody TodoPostDTO todo) {
        return ResponseEntity.ok().body(new TodoDTO(service.insert(todo)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
