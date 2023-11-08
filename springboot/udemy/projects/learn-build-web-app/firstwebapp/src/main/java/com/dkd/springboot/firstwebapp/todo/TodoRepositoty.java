package com.dkd.springboot.firstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepositoty extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
