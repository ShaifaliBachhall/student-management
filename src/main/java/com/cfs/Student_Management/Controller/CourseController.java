package com.cfs.Student_Management.Controller;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Service.CourseServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @PostMapping
    public Course save(@RequestBody Course course){
        return courseService.saveCourse(course);
    }
    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }
    @GetMapping("/{id}")
    public Course findById(@PathVariable Integer id){
        return courseService.findById(id);
    }
    @PostMapping("/update/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
       courseService.deleteCourse(id);
    }
}
