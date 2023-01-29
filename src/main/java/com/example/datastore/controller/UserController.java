package com.example.datastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.datastore.entity.User;
import com.example.datastore.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> listAllUsers(){
		List<User> users = userService.listAll();
		return users;
	}
	
	@PostMapping("/users/create")
	public User createNewUser(@RequestBody User user) {
		User save = userService.save(user);
		return save;
	}
}
