package com.springboot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.UserDTO;
import com.springboot.api.exceptions.UserNotFoundException;
import com.springboot.api.models.User;
import com.springboot.api.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Login Api Rest")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	public IUserService service;

	@GetMapping("/users")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public List<User> list() {
		return service.list();
	}

	@GetMapping("/user/{id}")
	public User listById(@PathVariable("id") long id) {
		return service.listById(id);
	}

	@PostMapping("/user/signup")
	public ResponseEntity<UserDTO> signup(@RequestBody UserDTO dto) throws UserNotFoundException {
		service.signup(dto.toUser());
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PostMapping("/user/signin")
	public ResponseEntity<UserDTO> signin(@RequestBody UserDTO dto) {
		String email = dto.toUser().getEmail();
		String password = dto.toUser().getPassword();
		User user = service.signin(email, password);
		return new ResponseEntity<>(dto.toUserDTO(user), HttpStatus.OK);
	}

	@PostMapping("/user/changePassword")
	public void changePassword() {

	}

	@PostMapping("/user/forgotPassword")
	public void forgotPassword() {

	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") long id) {
		service.delete(id);
	}

	@PutMapping("/user")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto) {
		User user = service.update(dto.toUser());
		return new ResponseEntity<>(dto.toUserDTO(user), HttpStatus.OK);
	}
}
