package com.cfs.Student_Management.Service;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Entity.Student;
import com.cfs.Student_Management.Repository.CourseRepo;
import com.cfs.Student_Management.Repository.StudentRepo;
import com.cfs.Student_Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Student saveStudent(Integer id, Student student) {
        Course existing=courseRepo.findById(id).orElseThrow(()->new RuntimeException("No student found with id: "+id));
        student.setCourse(existing);
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student existing=studentRepo.findById(id).orElseThrow(()->new RuntimeException("No student found with id: "+id));
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());
        existing.setCourse(student.getCourse());
        return studentRepo.save(existing);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student=studentRepo.findById(id).orElseThrow(()->new RuntimeException("No student found with id: "+id));
        studentRepo.delete(student);
        System.out.println("Student deleted successfully with id: "+id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepo.findById(id).orElseThrow(()->new RuntimeException("No student found with id: "+id));

    }

    @Override
    public List<Student> findByCourse(Integer course_id) {
        return studentRepo.findByCourseId(course_id);

    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public List<Student> findByAge(Integer age){
        return studentRepo.findByAge(age);
}
}
