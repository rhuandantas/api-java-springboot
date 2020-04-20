package com.springboot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.models.User;
import com.springboot.api.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Login Api Rest")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	public UserRepository repository;

	@GetMapping("/users")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public List<User> list() {
		return repository.findAll();
	}

	@GetMapping("/user/{id}")
	public User listById(@PathVariable("id") long id) {
		return repository.findById(id);
	}

	@PostMapping("/user")
	public void insert(@RequestBody User user) {
		repository.save(user);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}

	@PutMapping("/user")
	public User update(@RequestBody User user) {
		return repository.save(user);
	}
}
