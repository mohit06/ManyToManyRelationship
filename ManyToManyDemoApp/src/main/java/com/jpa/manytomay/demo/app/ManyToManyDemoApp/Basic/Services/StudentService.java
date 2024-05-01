package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Services;

import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.CourseEntity;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.StudentEntity;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseService courseService;

    public void saveStudentDetails(StudentEntity studentWithCourses) {
        Set<CourseEntity> courses = studentWithCourses.getCourses();
        courseService.checkAndReplaceExistingCourses(courses);
            studentWithCourses.setCourses(courses);
            studentRepository.save(studentWithCourses);

    }
}
