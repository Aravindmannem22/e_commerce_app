package org.jsp.ecommerceapp.dao;

import java.util.Optional;

import org.jsp.ecommerceapp.model.Merchant;
import org.jsp.ecommerceapp.repository.Merchantrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	public Merchantrepository merchantrepository;
	
	

	public Merchant saveMerchant(Merchant merchant) {
		return merchantrepository.save(merchant);
	}
	
	
	public Optional<Merchant> findById(int id) {
		return merchantrepository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Merchant> recMerchant = findById(id);
		if (recMerchant.isPresent()) {
			merchantrepository.delete(recMerchant.get());
			return true;
		}
		return false;
	}
	public Optional<Merchant> verify(String email, String password) {
		return merchantrepository.verify(email,password);
	}

	
	
	public Optional<Merchant> verifybyphone(long phone, String password) {
		return merchantrepository.verifybyphone(phone, password);
	}
	
	
		
	
	public Optional<Merchant> findbyToken(String token) {
		
		return merchantrepository.findByToken(token);
	}
	
	
	

	

}
