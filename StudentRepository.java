package com.jsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
