package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoResource {
    @Autowired
    private TodoService service;

    @GetMapping("/user/{username}/todos")
    public List<Todo> retriveTodos(@PathVariable String username)
    {
        return service.findByUsername(username);
    }
    @GetMapping("/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable int id)
    {
        return service.find(username,id);
    }

    @DeleteMapping("/user/{username}/todos/{id}")
    public void deleteTodoById(@PathVariable int id)
    {
        service.deleteById(id);
    }

    @PutMapping("/user/{username}/todos/{id}")
    public Todo update(@PathVariable String username, @PathVariable int id,  @RequestBody Todo todo)
    {
        service.updateTodo(todo);
        return todo;
    }
}
