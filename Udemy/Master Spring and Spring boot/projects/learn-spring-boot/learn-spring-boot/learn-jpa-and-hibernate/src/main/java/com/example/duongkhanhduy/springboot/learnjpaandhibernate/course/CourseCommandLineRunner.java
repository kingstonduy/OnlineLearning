package com.example.duongkhanhduy.springboot.learnjpaandhibernate.course;

import com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJpaRepository repository;
//    @Autowired
//    private CourseJdbcRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "CourseName1", "dkd"));
        repository.save(new Course(2, "CourseName2", "dkd"));
        repository.save(new Course(3, "CourseName3", "dkd"));


        repository.deleteById(1l);

        System.out.println(repository.findAll());

    }
}
