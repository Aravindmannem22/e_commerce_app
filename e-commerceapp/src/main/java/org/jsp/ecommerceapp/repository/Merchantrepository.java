package org.jsp.ecommerceapp.repository;

import java.util.Optional;

import org.jsp.ecommerceapp.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface Merchantrepository extends JpaRepository<Merchant, Integer>{

	
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	Optional<Merchant> verify(String email, String password);

	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	Optional<Merchant> verifybyphone(long phone, String password);
	
	

	Optional<Merchant> findByToken(String token);
}
