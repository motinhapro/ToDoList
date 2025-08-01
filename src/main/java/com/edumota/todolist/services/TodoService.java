package com.edumota.todolist.services;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.dto.TodoPostDTO;
import com.edumota.todolist.dto.TodoUpdateDTO;
import com.edumota.todolist.enums.Priority;
import com.edumota.todolist.repositories.TodoRepository;
import com.edumota.todolist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Todo> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Todo> findByPriority(String value) {
        Priority priority = Priority.valueOf(value.toUpperCase());
        return repository.findByPriority(priority);
    }

    public List<Todo> findAllByPriority(String value) {
        Sort.Direction direction;
        try {
            direction = Sort.Direction.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            direction = Sort.Direction.ASC;
        }

        return repository.findAll(Sort.by(direction, "priority"));
    }

    public Todo update(Long id, TodoUpdateDTO newTodo) {
        Todo todo = findById(id);
        todo.setTitle(newTodo.getTitle());
        todo.setDescription(newTodo.getDescription());
        todo.setStatus(newTodo.getStatus());
        todo.setPriority(newTodo.getPriority());
        todo.setDueDate(newTodo.getDueDate());
        return repository.save(todo);
    }

    public Todo insert(TodoPostDTO todo) {
        return repository.save(new Todo(null, todo.getTitle(), todo.getDescription(), todo.getStatus(), todo.getPriority(), todo.getDueDate()));
    }

    public void delete(Long id) {
        Todo todo = findById(id);
        repository.deleteById(id);
    }

}
