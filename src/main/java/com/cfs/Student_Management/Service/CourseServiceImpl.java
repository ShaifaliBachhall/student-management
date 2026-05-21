package com.cfs.Student_Management.Service;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Integer id,Course course) {
        Course existing=courseRepo.findById(id).orElseThrow(()->new RuntimeException("No course found with id: "+id));
        existing.setCourse_name(course.getCourse_name());
        existing.setDuration(course.getDuration());
        existing.setFees(course.getFees());
        return courseRepo.save(existing);
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course=courseRepo.findById(id).orElseThrow(()->new RuntimeException("Course not found with id: "+id));
        courseRepo.delete(course);
        System.out.println("Course deleted successfully!");

    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepo.findById(id).orElseThrow(()->new RuntimeException("Course not found with id: "+id));
    }
}
