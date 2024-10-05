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
public class UserRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Role role ;
	
}