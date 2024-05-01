package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Repositories;

import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    Optional<CourseEntity> findByTitle(String title);
}
