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
@NoArgsConstructor

public class TodoDTO {

    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime createdAt;

    public TodoDTO(Todo x) {
        this.title = x.getTitle();
        this.description = x.getDescription();
        this.status = x.getStatus();
        this.priority = x.getPriority();
        this.createdAt = x.getCreatedAt();
    }
}
