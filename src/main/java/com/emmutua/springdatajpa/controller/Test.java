package com.emmutua.springdatajpa.controller;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Test {
    @Autowired
    private CourseRepository courseRepository;
    @RequestMapping("/courses")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
}
