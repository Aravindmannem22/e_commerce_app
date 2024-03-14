package org.jsp.ecommerceapp.dao;

import java.util.Optional;

import org.jsp.ecommerceapp.model.Merchant;
import org.jsp.ecommerceapp.model.User;
import org.jsp.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
	public UserRepository userrepository;

	public User saveUser(User user) {
		
		return userrepository.save(user);
	}

	

	public Optional<User> findById(int id) {
		return userrepository.findById(id);
	}
	


	public boolean deleteById(int id) {
		Optional<User> recUser = findById(id);
		if (recUser.isPresent()) {
			userrepository.delete(recUser.get());
			return true;
		}
		return false;
		
	}

	

}
