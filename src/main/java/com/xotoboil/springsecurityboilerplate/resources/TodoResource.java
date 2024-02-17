package com.xotoboil.springsecurityboilerplate.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final List<Todo> TODOS_LIST = List.of(new Todo("Halbtale", "Create Spring Project"), new Todo("Halbtale", "Create AWS Project"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodoForUser(@PathVariable String username) {
        return TODOS_LIST.getFirst();
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Creating {} for {}", todo, username);
    }
}

record Todo (String username, String description) {}