package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
