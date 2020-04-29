package com.springboot.api.service;

import java.util.List;

import com.springboot.api.exceptions.UserNotFoundException;
import com.springboot.api.models.User;

public interface IUserService {

	List<User> list();

	User listById(long id);

	User signin(String email, String password);

	void signup(User user) throws IllegalArgumentException, UserNotFoundException;

	void changePassword();

	void forgotPassword();

	void createPasswordResetTokenForUser(User user, String token);

	void delete(Long id);

	User update(User user);
}
