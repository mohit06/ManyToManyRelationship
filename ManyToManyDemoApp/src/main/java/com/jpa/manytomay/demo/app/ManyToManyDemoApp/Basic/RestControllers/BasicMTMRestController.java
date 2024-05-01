package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.RestControllers;

import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.CourseEntity;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.StudentEntity;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Repositories.StudentRepository;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Services.CourseService;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BasicMTMRestController {

    private final StudentService studentService;
    @PostMapping("/basic")
    public ResponseEntity<Void> saveStudentAndCourseRelationship(@RequestBody List<StudentEntity> studentWithCoursesList){
        studentWithCoursesList.forEach(studentService::saveStudentDetails);
        return ResponseEntity.ok(null);
    }
}
