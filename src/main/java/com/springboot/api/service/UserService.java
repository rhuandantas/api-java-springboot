package com.springboot.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.api.exceptions.UserNotFoundException;
import com.springboot.api.models.PasswordResetToken;
import com.springboot.api.models.User;
import com.springboot.api.repository.PasswordTokenRepository;
import com.springboot.api.repository.UserRepository;

@Component
public class UserService implements IUserService {

	private UserRepository userRepository;
	private PasswordTokenRepository passwordTokenRepository;

	@Autowired
	public UserService(UserRepository userRepository, PasswordTokenRepository passwordTokenRepository) {
		this.userRepository = userRepository;
		this.passwordTokenRepository = passwordTokenRepository;
	}

	@Override
	public User signin(String email, String password) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken myToken = new PasswordResetToken(user, token);
		passwordTokenRepository.save(myToken);

	}

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public User listById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public void signup(User user) throws IllegalArgumentException, UserNotFoundException {
		try {
			validateUserParams(user);
			User usuario = userRepository.findByEmail(user.getEmail());
			if (usuario != null)
				throw new UserNotFoundException();

			userRepository.save(user);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private void validateUserParams(User user) {
		if (user.getEmail() == null || user.getEmail().isEmpty())
			throw new IllegalArgumentException();

		if (user.getPassword() == null || user.getPassword().isEmpty())
			throw new IllegalArgumentException();

		if (user.getName() == null || user.getName().isEmpty())
			throw new IllegalArgumentException();
	}

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void forgotPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User update(User user) {
		if (user.getId() <= 0)
			throw new IllegalArgumentException();
		return userRepository.save(user);
	}

}
