package org.jsp.ecommerceapp.service;

import java.util.Optional;

import org.jsp.ecommerceapp.dao.UserDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.Merchant;
import org.jsp.ecommerceapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<User> saveUser(User user){
		ResponseStructure<User> structure =new ResponseStructure<>();
		structure.setBody(userDao.saveUser(user));
		structure.setMessage("User saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<User>(HttpStatus.CREATED);
		}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		Optional<User> recUser =userDao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("user found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		structure.setBody(null);
		structure.setMessage("user Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		Optional<User> recUser = userDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setMessage("User found");
			structure.setBody("User deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			userDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Merchant Not found");
		structure.setBody("cannot delete merchant as Id is Invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
		

	
	
	

}
