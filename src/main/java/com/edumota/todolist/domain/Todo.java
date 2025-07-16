package com.edumota.todolist.domain;

import com.edumota.todolist.enums.Priority;
import com.edumota.todolist.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;

    public Todo() {
        this.createdAt = LocalDateTime.now();
    }

    public Todo(Long id, String title, String description, Status status, Priority priority, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
        this.dueDate = dueDate;
    }
}
