package com.cfs.Student_Management.Service;

import com.cfs.Student_Management.Entity.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {
    Course saveCourse(Course course);
    Course updateCourse(Integer id,Course course);
    void deleteCourse(Integer id);
    List<Course> findAll();
    Course findById(Integer id);
}
