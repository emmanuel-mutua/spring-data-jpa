package com.emmutua.springdatajpa.repository;

import com.emmutua.springdatajpa.entity.Course;
import com.emmutua.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
