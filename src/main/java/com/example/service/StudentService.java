package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enity.Student;
import com.example.repository.StudentRepository;
import com.example.request.StudentAddRequest;
import com.example.request.StudentUpdateRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository; // Creating the instance of student repository

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent(StudentAddRequest studentRequest) {
		Student student = new Student(studentRequest); // Passing the details and crating a student entry object

		return studentRepository.save(student); // Saving the student details to student table using JPA repository
	}

	public Student updateStudent(StudentUpdateRequest studentUpdateRequest) {

		Student student = new Student(studentUpdateRequest); // Passing the details and crating a student entry object

		return studentRepository.save(student); // Updating the student record

	}

	public String deleteStudent(Long Id) {

		try {
			studentRepository.deleteById(Id);
		} catch (Exception e) {
			return "Error in deletion";
		}

		return "Student has been deleted successfully";
	}
}
