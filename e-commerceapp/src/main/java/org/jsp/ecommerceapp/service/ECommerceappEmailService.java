package org.jsp.ecommerceapp.service;

import static org.jsp.ecommerceapp.util.ApplicationConstants.VERIFY_LINK;

import org.jsp.ecommerceapp.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ECommerceappEmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	

	public String sendWelcomeMail(Merchant merchant, HttpServletRequest request) {
		String siteUrl= request.getRequestURL().toString();
		String url= siteUrl.replace(request.getServletPath(), "");
		String actual_url= url + VERIFY_LINK + merchant.getToken();
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(merchant.getEmail());
			helper.setSubject("Activate your Account");
			helper.setText(actual_url);
			javaMailSender.send(message);
			return "verification mail has been sent";
		}catch(MessagingException e){
			e.printStackTrace();
			return "cannot send verification mail";
		}
	}
	

}
