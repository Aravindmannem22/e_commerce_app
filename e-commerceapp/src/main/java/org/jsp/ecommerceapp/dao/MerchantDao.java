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
	

	

}
