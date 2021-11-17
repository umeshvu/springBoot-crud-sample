package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.enity.Student;
import com.example.request.StudentAddRequest;
import com.example.request.StudentUpdateRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api-v1/students")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@GetMapping("/getAllStudent")
	public List<StudentResponse> GetAllStudent() {
		
		logger.error("Error");//Default level
		logger.warn("Warn"); //Default level
		logger.info("Info"); //Default level
		logger.trace("Trace"); //Need to enable
		logger.debug("Debug"); //Need to enable

		List<Student> studentList = studentService.getAllStudents(); // Getting all student list

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>(); // Creating response object

		studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student))); // formating the
																										// response
		return studentResponseList;

	}

	@PostMapping("/addStudent")
	public StudentResponse addStudent(@Valid @RequestBody StudentAddRequest studdentRequest) {

		Student newlyAdded = studentService.addStudent(studdentRequest);

		return new StudentResponse(newlyAdded);
	}

	@PutMapping("/updateStudent")
	public StudentResponse UpdateStudentById(@Valid @RequestBody StudentUpdateRequest studdentUpdateRequest) {

		Student updatedStudent = studentService.updateStudent(studdentUpdateRequest);

		return new StudentResponse(updatedStudent);
	}

	@DeleteMapping("/deleteStudent")
	public String DeleteStudentById(@RequestParam Long id) {
		
		return studentService.deleteStudent(id);
		
	}

}
