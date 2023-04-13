package com.DuongKhanhDuy.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourese(){
        return Arrays.asList(
                new Course(1, "learn spring boot", "dkd"),
                new Course(2, "learn back end", "dkd")
        );
    }
}
