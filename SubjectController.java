package com.jsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.dto.Subject;
import com.jsp.helper.ResponseStructure;
import com.jsp.repository.SubjectRepository;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectRepository sr;
	
	@PostMapping("/saveSubject") // it used to handle post request .
	public ResponseStructure<Subject> saveSubject(@RequestBody Subject s) {
		sr.save(s);
		ResponseStructure<Subject> rs = new ResponseStructure<Subject>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setData(s);
		rs.setMessage("data saved successfully....");

		return rs;
	}
	
	@GetMapping("/fetchAllSubject") // it used to handle get request for fetch the subjects
	public List<Subject> fetchAllSubjects(){
		return sr.findAll();
	}

}
