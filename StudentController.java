package com.jsp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.repository.StudentRepository;
import com.jsp.repository.SubjectRepository;
import com.jsp.dto.Student;
import com.jsp.dto.Subject;
import com.jsp.helper.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	StudentRepository sr;

	@Autowired
	SubjectRepository subr;

	@PostMapping("/saveStudent") // it used to handle post request for save the student
	public ResponseStructure<Student> saveStudent(@RequestBody Student s) {
		sr.save(s);
		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setData(s);
		rs.setMessage("data saved successfully....");

		return rs;
	}

	@GetMapping("/fetchAllStudent") // it used to handle get request for fetch the students
	public List<Student> fetchAllStudents() {
		return sr.findAll();
	}

	@PostMapping("/{studentId}/enroll/{subjectId}")
	public ResponseEntity<Student> enrollStudentToSubject(@PathVariable int studentId, @PathVariable int subjectId) {
		
		Optional<Student> stuop = sr.findById(studentId);
		Optional<Subject> subop = subr.findById(subjectId);
		
		Student student = stuop.get();
		Subject subject = subop.get();

		student.getSubjects().add(subject);
		sr.save(student);

		return ResponseEntity.ok(student);
	}

}
