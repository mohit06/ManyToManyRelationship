package com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Services;

import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Entities.CourseEntity;
import com.jpa.manytomay.demo.app.ManyToManyDemoApp.Basic.Repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public void checkAndReplaceExistingCourses(Set<CourseEntity> courses) {
        List<CourseEntity> existingCourses = new LinkedList<CourseEntity>();

        Iterator<CourseEntity> courseIterator = courses.iterator();
        while(courseIterator.hasNext()){
            CourseEntity entity = courseIterator.next();
            Optional<CourseEntity> course = courseRepository.findByTitle(entity.getTitle());
            course.ifPresent(existingCourse -> courseIterator.remove());
            course.ifPresent(existingCourses::add);
        }

        courses.addAll(existingCourses);
    }


}

