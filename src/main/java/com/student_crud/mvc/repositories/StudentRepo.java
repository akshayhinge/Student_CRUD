package com.student_crud.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_crud.mvc.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
