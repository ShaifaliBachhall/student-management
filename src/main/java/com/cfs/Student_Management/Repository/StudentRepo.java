package com.cfs.Student_Management.Repository;

import com.cfs.Student_Management.Entity.Course;
import com.cfs.Student_Management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByCourseId(Integer course);
    List<Student> findByAge(Integer age);
}
