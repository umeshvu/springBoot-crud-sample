package com.example.response;

import org.springframework.beans.factory.annotation.Value;

import com.example.enity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // Getter and setter with lombok without writing all the boiler plate code
public class StudentResponse {

	@JsonIgnore //ignoring the this from json
	@Value("${app.name:Default Demo App}")
	private String appName;

	
	private long id;
	@JsonProperty("firstName") // Changing the key
	private String name;
	private String lastName;
	private String email;
	
	public StudentResponse(Student student) { //Constructor
		this.id = student.getId();
		this.name = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
	}
}
