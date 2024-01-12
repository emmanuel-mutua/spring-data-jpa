package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Learn more on the JPQL Queries
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String chars);
//    @Query("SELECT s from Student where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query(
            value = "SELECT * FROM student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT * FROM student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


    @Modifying
    @Transactional //Learn more on transactions
    @Query(
           value = "update student set first_name = ?1 where email_address = ?2",
           nativeQuery = true
   )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
