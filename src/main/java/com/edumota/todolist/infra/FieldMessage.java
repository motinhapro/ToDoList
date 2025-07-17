package com.edumota.todolist.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class FieldMessage {

    private String fieldName;
    private String message;
}
