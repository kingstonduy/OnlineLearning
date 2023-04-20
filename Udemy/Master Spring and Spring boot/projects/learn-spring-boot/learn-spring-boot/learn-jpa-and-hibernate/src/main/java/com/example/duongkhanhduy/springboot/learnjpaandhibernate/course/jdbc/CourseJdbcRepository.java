package com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.jdbc;

import com.example.duongkhanhduy.springboot.learnjpaandhibernate.course.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate spingJdbcTemplate;
    private static String INSERT_QUERY=
            """
                    insert into course (id, name, author)
                    values(?, ?, ?);
                    """;
    public static String DELETE_QUERY=
            """
                    delete from course
                    where id= ?
                    """;
    public static String SELECT_QUERY=
            """
                    select * from course
                    where id= ?
                    """;
    public void insert(Course course){
        spingJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(long id)
    {
        spingJdbcTemplate.update(DELETE_QUERY, id);
    }
    public Course findById(long id)
    {
        return spingJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
