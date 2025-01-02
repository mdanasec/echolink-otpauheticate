package org.jsp.springbootecholink.controller;

import org.jsp.springbootecholink.model.ResponseStructure;
import org.jsp.springbootecholink.model.User;
import org.jsp.springbootecholink.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpController {
	@Autowired
	private OtpService otpService;

	@PostMapping("/sendOtp")
	public ResponseStructure<String> sendOtp(@RequestParam String mobileNumber) {
		return otpService.sendOtpToPhone(mobileNumber);
	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<ResponseStructure<User>> verifyOtp(@RequestBody User user) {
		return otpService.verifyOtp(user.getMobileNumber(), user.getOtp(), user.getUserName(), user.getEmail(),
				user.getPassword());
	}

}
