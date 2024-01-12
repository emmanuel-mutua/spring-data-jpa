package com.emmutua.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
