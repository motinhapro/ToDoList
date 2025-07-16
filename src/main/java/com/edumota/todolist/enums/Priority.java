package com.edumota.todolist.enums;

import lombok.Getter;

@Getter

public enum Priority {
    LOW("Low"),
    MEDIUM("Medium"),
    URGENT("Urgent");

    private final String label;

    Priority(String label) {
        this.label = label;
    }
}
