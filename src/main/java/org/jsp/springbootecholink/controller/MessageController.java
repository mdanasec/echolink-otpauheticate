package org.jsp.springbootecholink.controller;

import org.jsp.springbootecholink.model.Message;
import org.jsp.springbootecholink.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public Message sendMessage (@RequestBody Message message) {
		return messageService.sendMessage(message);
	}
	
	
//	@GetMapping("/")
//	public String home() {
//		return "Welcome to spring boot project for sending otp to mobile";
//	}

	
	
//	@GetMapping("/user/{userId}")
//	public ResponseEntity<ResponseStructure<List<Message>>> getMessageByUser(@PathVariable User userId){
//		return messageService.getMessageByUser(userId);
//	}
	
	
}
