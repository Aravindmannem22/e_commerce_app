package org.jsp.ecommerceapp.controller;



import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.Merchant;
import org.jsp.ecommerceapp.service.Merchantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping("/merchants")
public class MerchantController {
	@Autowired
	private Merchantservice merchantservice;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Merchant> saveMerchant(@RequestBody Merchant merchant,HttpServletRequest request){
		return merchantservice.saveMerchant(merchant, request);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable(name = "id") int id) {
		return merchantservice.findById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "id") int id) {
		return merchantservice.deleteById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantservice.updateMerchant(merchant);
	}
	@PostMapping("/verify")
	public ResponseEntity<ResponseStructure<Merchant>> verify(@RequestParam String email,
			@RequestParam String password) {
		return merchantservice.verify(email, password);
	}
	@PostMapping("/verifybyphone")
	public ResponseEntity<ResponseStructure<Merchant>> verifybyphone(@RequestParam long phone,
			@RequestParam String password) {
		return merchantservice.verifybyphone(phone, password);
	}
	@GetMapping("/activate")
	public ResponseEntity<ResponseStructure<String>> activate(@RequestParam String token){
		return merchantservice.activate(token);
	}
}
