package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.entity.Student;
import com.emmutua.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
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

//    @Test
//    public void findAllPagination(){
//        Pageable firstPagewithThreeRecords =
//                PageRequest.of(0, 3);
//        Pageable secondPageWithTwoRecords =
//                PageRequest.of(1,2);
//
//        List<Course> courses =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getContent();
//
//        long totalElements =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getTotalElements();
//
//        long totalPages =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getTotalPages();
//
//        System.out.println("totalPages = " + totalPages);
//
//        System.out.println("totalElements = " + totalElements);
//
//        System.out.println("courses = " + courses);
//    }

//    @Test
//    public void findAllSorting() {
//        Pageable sortByTitle =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title")
//                );
//        Pageable sortByCreditDesc =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("credit").descending()
//                );
//
//        Pageable sortByTitleAndCreditDesc =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title")
//                                .descending()
//                                .and(Sort.by("credit"))
//                );
//
//        List<Course> courses
//                = courseRepository.findAll(sortByTitle).getContent();
//
//        System.out.println("courses = " + courses);
//    }


//    @Test
//    public void printfindByTitleContaining() {
//        Pageable firstPageTenRecords =
//                PageRequest.of(0,10);
//
//        List<Course> courses =
//                courseRepository.findByTitleContaining(
//                        "D",
//                        firstPageTenRecords).getContent();
//
//        System.out.println("courses = " + courses);
//    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Student student = Student.builder()
                .lastName("Student1")
                .firstName("Student")
                .emailId("kjdsh@gmail.com")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Emmanuel")
                .lastName("Munyao")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credits("6")
                .teacher(teacher)
//                .courseMaterial()
//                .students()
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}