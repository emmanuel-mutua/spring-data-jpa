package com.emmutua.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The relationship btwn a course and student is many to many relationship
 * We need to create an extra table that holds the relationship
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "course",
        uniqueConstraints = @UniqueConstraint(
                name = "course_title_unique",
                columnNames = "course_title"
        )
)
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence", //Sq name in db where shall get the prk
            allocationSize = 1
    )
    @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "course_sequence"
    )
    private Long courseId;
    @Column(
            name = "course_title"
    )
    private String title;
    private String credits;

    //Bidirectional one to one mapping
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if (students == null) students = new ArrayList<>();
        students.add(student);
    }
}
