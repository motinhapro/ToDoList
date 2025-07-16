package com.edumota.todolist.config;

import com.edumota.todolist.domain.Todo;
import com.edumota.todolist.enums.Priority;
import com.edumota.todolist.enums.Status;
import com.edumota.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {

        Todo td1 = new Todo(null, "Estudar", "Estudar javascript e css", Status.PENDING, Priority.MEDIUM, LocalDateTime.now().plusDays(5));
        Todo td2 = new Todo(null, "Limpar o quarto", "Limpar o quarto logo", Status.PENDING, Priority.URGENT, LocalDateTime.now().plusDays(1));
        Todo td3 = new Todo(null, "Fazer o trabalho", "Fazer trabalho de redes", Status.IN_PROGRESS, Priority.LOW, LocalDateTime.now().plusDays(15));

        todoRepository.saveAll(Arrays.asList(td1, td2, td3));
    }
}
