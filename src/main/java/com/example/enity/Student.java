package com.example.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.request.StudentAddRequest;
import com.example.request.StudentUpdateRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //default constructor is mandatory for entity class, this will act as default
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	public Student(StudentAddRequest student) { //parameterized constructor for adding new student
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
	}
	
	public Student(StudentUpdateRequest studentUpdateRequest) { //parameterized constructor for updating a record
		this.id = studentUpdateRequest.getId();
		this.firstName = studentUpdateRequest.getFirstName();
		this.lastName = studentUpdateRequest.getLastName();
		this.email = studentUpdateRequest.getEmail();
	}

}
