package com.cfs.Student_Management.Service;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Student saveStudent(Integer id, Student student);
    Student updateStudent(Integer id, Student student);
    void deleteStudent(Integer id);
    Student findById(Integer id);
    List<Student> findByCourse(Integer id);
    List<Student> findAll();
    List<Student> findByAge(Integer age);

}
