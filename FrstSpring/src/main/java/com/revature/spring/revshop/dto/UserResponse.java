package com.revature.spring.revshop.dto;

import com.revature.spring.revshop.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {
	private long id; 
	private String firstName;
	private String lastName;
	private String email;
	private Role role ;
	

}