package com.emmutua.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable //Embedd to student
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "name",
                        column = @Column(name = "guardian_name")
                ),
                @AttributeOverride(
                        name = "email",
                        column = @Column(name = "guardian_email")
                ),
                @AttributeOverride(
                        name = "mobile",
                        column = @Column(name = "guardian_mobile")
                ),
        }
)
@Builder
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}