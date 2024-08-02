package com.jsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.dto.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
