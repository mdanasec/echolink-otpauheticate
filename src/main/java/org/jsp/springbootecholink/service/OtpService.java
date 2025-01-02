package org.jsp.springbootecholink.service;

import java.util.HashMap;
import java.util.Map;

import org.jsp.springbootecholink.config.TwilioConfig;
import org.jsp.springbootecholink.exception.OtpException;
import org.jsp.springbootecholink.model.ResponseStructure;
import org.jsp.springbootecholink.model.User;
import org.jsp.springbootecholink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;

@Service
public class OtpService {

	@Autowired
	private TwilioConfig twilioConfig;

	@Autowired
	private UserRepository userRepository;

	Map<String, String> otpMap = new HashMap<>();

	public ResponseStructure<String> sendOtpToPhone(String mobileNumber) { 

		ResponseStructure<String> structure = new ResponseStructure<>();

		try {
			String otp = generateOtp();

			PhoneNumber recieverPhoneNumber = new PhoneNumber(mobileNumber);
			PhoneNumber senderPhoneNumber = new PhoneNumber(twilioConfig.getPhoneNumber());

			String msgBody = "Your one time password is : " + otp;
			Message message = Message.creator(recieverPhoneNumber, senderPhoneNumber, msgBody).create();
			otpMap.put(mobileNumber, otp);

			structure.setMessage("OTP sent sucessfully !");
			structure.setData(otp);
			structure.setStatusCode(HttpStatus.OK.value());

		} catch (Exception e) {
			throw new OtpException("Faild to send OTP. plese try again");
		}
		return structure;

	}

//helper method
	private String generateOtp() {
		int otp = (int) (Math.random() * 1000000);
		return String.format("%06d", otp);
	}

	public ResponseEntity<ResponseStructure<User>> verifyOtp(String mobileNumber,String otp, String userName, String email,
			String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();

		 
		String saveOtp = otpMap.get(mobileNumber);
		if (saveOtp != null && saveOtp.equals(otp)) {
			User user = new User();
			user.setMobileNumber(mobileNumber);
			user.setUserName(userName);
			user.setEmail(email);
			user.setPassword(password);
			user.setOtp(otp);

			userRepository.save(user);
			otpMap.remove(mobileNumber);

			structure.setMessage("User Verfied and saved sucessfully! ");
			structure.setData(user);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(structure, HttpStatus.OK);

		} else {
			structure.setMessage("Invalid OTP");
			structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);

		}
	}

}
