package com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.jdbc;

import com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "name1", "author1"));
        repository.insert(new Course(2, "name2", "author2"));
        repository.insert(new Course(3, "name3", "author3"));
        repository.insert(new Course(4, "name4", "author4"));

        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
