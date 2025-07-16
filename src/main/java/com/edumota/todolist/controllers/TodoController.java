package com.edumota.todolist.controllers;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    public List<Todo> findAll() {
        return service.findAll();
    }
}
