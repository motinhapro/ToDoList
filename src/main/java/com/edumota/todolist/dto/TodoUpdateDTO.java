package com.edumota.todolist.dto;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.enums.Priority;
import com.edumota.todolist.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TodoUpdateDTO {

    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime dueDate;

    public TodoUpdateDTO(Todo todo) {
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
        this.priority = todo.getPriority();
        this.dueDate = todo.getDueDate();
    }
}
