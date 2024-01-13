package com.emmutua.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "course_url_unique",
                        columnNames = "course_url"
                )
        }
)
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
          strategy =  GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;

    @Column(
            name = "course_url",
            nullable = false
    )
    private String url;

    @OneToOne(
            //Pass permissions to child elem to allow save a course-material
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false //You cant save a course-material without a course
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
