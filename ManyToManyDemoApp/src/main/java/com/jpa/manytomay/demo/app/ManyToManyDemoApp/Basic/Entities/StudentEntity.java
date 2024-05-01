package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name="students")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "roll_number", unique = true, nullable = false)
    private int rollNo;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "courses_subscribed_by_students",
            joinColumns = @JoinColumn(name = "id_of_the_student"),
            inverseJoinColumns = @JoinColumn(name = "id_of_the_course"))
    private Set<CourseEntity> courses;


}
