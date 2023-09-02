package com.osttra.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	private String username;
	private String password;
	private String email;
	private String completeName;
	private String role;
	private String isApproved;

}
