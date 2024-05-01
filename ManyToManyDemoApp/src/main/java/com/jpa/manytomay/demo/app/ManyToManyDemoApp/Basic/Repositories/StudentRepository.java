package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Repositories;

import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByRollNo(int rollNo);
}
