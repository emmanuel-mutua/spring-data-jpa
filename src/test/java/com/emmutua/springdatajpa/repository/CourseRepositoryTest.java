package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Jacob")
                .lastName("Juma")
                .build();
        Course course = Course.builder()
                .title("Python")
                //.courseMaterial()
                .teacher(teacher)
                .credits("6")
                .build();
        courseRepository.save(course);
    }

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses: " + courses);
    }
}