package com.springboot.api.dto;

import com.springboot.api.models.User;

public class UserDTO {
	private long id;
	private String name;
	private String email;
	private String password;

	private UserDTO(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public User toUser() {
		return new User(id, name, email, password);
	}

	public UserDTO toUserDTO(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
	}
}
