package org.jsp.ecommerceapp.service;

import java.util.Optional;

import org.jsp.ecommerceapp.dao.MerchantDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.exception.MerchantNotFoundException;
import org.jsp.ecommerceapp.model.Merchant;
import org.jsp.ecommerceapp.util.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class Merchantservice {
	@Autowired
	private MerchantDao merchantDao;
	@Autowired
	private ECommerceappEmailService emailService;

	public ResponseEntity<Merchant> saveMerchant(Merchant merchant, HttpServletRequest request) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		merchant.setStatus(AccountStatus.IN_ACTIVE.toString());
		merchant.setToken(RandomString.make(45));
		structure.setBody(merchantDao.saveMerchant(merchant));
		String message = emailService.sendWelcomeMail(merchant, request);
		structure.setMessage("Merchant saved," + message);
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<Merchant>(HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> findById(int id) {
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setBody(recMerchant.get());
			structure.setMessage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setBody(null);
		structure.setMessage("Merchant Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {

		Optional<Merchant> recMerchant = merchantDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Merchant found");
			structure.setBody("Merchant deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			merchantDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Merchant Not found");
		structure.setBody("cannot delete merchant as Id is Invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = merchantDao.findById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant dbMerchant = recMerchant.get();
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setName(merchant.getName());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());
			structure.setMessage("Merchant Updated");
			structure.setBody(merchantDao.saveMerchant(merchant));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setMessage("Cannot Update Merchant as Id is Invalid");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verify(String email, String password) {
		Optional<Merchant> recMerchant = merchantDao.verify(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Invalid email Number or Password");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifybyphone(long phone, String password) {
		Optional<Merchant> recMerchant = merchantDao.verifybyphone(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Invalid phone Number or Password");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<String>> activate(String token) {
		Optional<Merchant> recMerchant = merchantDao.findbyToken(token);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant merchant = recMerchant.get();
			merchant.setStatus(AccountStatus.ACTIVE.toString());
			merchant.setToken(null);
			merchantDao.saveMerchant(merchant);
			structure.setBody("Merchant Found");
			structure.setMessage("Account Verified and Activated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setMessage("Account not verified");
		structure.setBody("merchant not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
}
