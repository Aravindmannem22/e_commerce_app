package org.jsp.ecommerceapp.controller;

import org.jsp.ecommerceapp.dto.ResponseStructure;

import org.jsp.ecommerceapp.model.User;
import org.jsp.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userservice;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return userservice.saveUser(user);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name = "id") int id) {
		return userservice.findById(id);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "id") int id) {
		return userservice.deleteById(id);
	}

}
