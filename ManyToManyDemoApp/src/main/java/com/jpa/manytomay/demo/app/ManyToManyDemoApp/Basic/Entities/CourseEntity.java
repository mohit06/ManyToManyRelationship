package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "courses")
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_title")
    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentEntity> students;

}
