package org.jsp.springbootecholink.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {

	private String accountSid;

	private String authToken;

	private String phoneNumber;

	public TwilioConfig() {
		super();
	}

	public TwilioConfig(String accountSid, String authToken, String phoneNumber) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.phoneNumber = phoneNumber;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "TwilioConfig [accountSid=" + accountSid + ", authToken=" + authToken + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
