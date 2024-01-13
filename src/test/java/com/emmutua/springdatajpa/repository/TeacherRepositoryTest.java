package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseJava = Course.builder()
                .title("Java")
                .credits("6")
                .build();
        Course courseKotlin = Course.builder()
                .title("Kotlin")
                .credits("6")
                .build();
        Teacher teacher  = Teacher.builder()
                .firstName("Emmanuel")
                .lastName("Mutua")
//                .courses(List.of(courseJava,courseKotlin))
                .build();

        teacherRepository.save(teacher);
    }

}