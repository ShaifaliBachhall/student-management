package com.cfs.Student_Management.Controller;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Entity.Student;
import com.cfs.Student_Management.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping({"/save/{course_id}"})
    public Student save(@PathVariable Integer course_id, @RequestBody Student student){
        return studentService.saveStudent(course_id,student);
    }
    @GetMapping("/id/{id}")
    public Student findById(@PathVariable Integer id){
        return studentService.findById(id);
    }
    @GetMapping("/course/{course_id}")
    public List<Student> findByCourse(@PathVariable Integer course_id){
        return studentService.findByCourse(course_id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @GetMapping("/age/{age}")
    public List<Student> findByAge(@PathVariable Integer age){
        return studentService.findByAge(age);
    }
}
