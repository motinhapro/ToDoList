package com.edumota.todolist.enums;

import lombok.Getter;

@Getter

public enum Status {

    PENDING("Pending"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed");

    private final String label;

    Status(String label) {
        this.label = label;
    }
}
