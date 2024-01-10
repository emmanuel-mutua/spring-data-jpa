package com.emmutua.springdatajpa;

import com.emmutua.springdatajpa.entity.Guardian;
import com.emmutua.springdatajpa.entity.Student;
import com.emmutua.springdatajpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("test@gmail.com")
                .firstName("fname")
                .lastName("lname")
                //.guardianName("gname")
                //.guardianEmail("test2@gmail.com")
                //.guardianMobile("04830934")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("gname")
                .email("test3@gmail.com")
                .mobile("04830934")
                .build();
        Student student = Student.builder()
                .emailId("test23@gmail.com")
                .firstName("fname")
                .lastName("lname")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List:" + studentList);
    }
}
