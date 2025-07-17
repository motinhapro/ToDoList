package com.edumota.todolist.dto;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.enums.Priority;
import com.edumota.todolist.enums.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class TodoUpdateDTO {

    @NotBlank
    @Size(max = 50)
    private String title;
    @Size(max = 100)
    private String description;
    private Status status;
    private Priority priority;
    @Future
    private LocalDateTime dueDate;

    public TodoUpdateDTO(Todo todo) {
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
        this.priority = todo.getPriority();
        this.dueDate = todo.getDueDate();
    }
}
