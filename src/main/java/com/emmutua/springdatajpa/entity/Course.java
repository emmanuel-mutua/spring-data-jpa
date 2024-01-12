package com.emmutua.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer credits;

    //Bidirectional one to one mapping
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
}
