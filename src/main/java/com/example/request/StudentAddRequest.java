package com.example.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAddRequest {

	@NotBlank(message = "First name is mandatory") //validating first name
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message = "Email is mandatory") //validating first name
	private String email;

}
