package org.jsp.ecommerceapp.dao;

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
	

}