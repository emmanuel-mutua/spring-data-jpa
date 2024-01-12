package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credits(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("courses/springdatajpa2")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
        // tring to save a course material without saving a course,
        //Want to implement cascading -> Pass permissions to child

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Materials: " + courseMaterials);
    }
}