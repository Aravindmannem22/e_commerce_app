package org.jsp.ecommerceapp.exception;

public class MerchantNotFoundException  extends RuntimeException {
	public MerchantNotFoundException(String string) {
		
	}

	public String getMessage() {
		return "Invalid merchant";
	}

}
