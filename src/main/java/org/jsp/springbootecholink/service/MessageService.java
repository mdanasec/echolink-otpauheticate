package org.jsp.springbootecholink.service;

import java.util.List;

import org.jsp.springbootecholink.model.Message;
import org.jsp.springbootecholink.model.ResponseStructure;
import org.jsp.springbootecholink.model.User;
import org.jsp.springbootecholink.repository.MessageRepository;
import org.jsp.springbootecholink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Message sendMessage(Message message) {
		return messageRepository.save(message);
	}

	
//	public ResponseEntity<ResponseStructure<List<Message>>> getMessageByUser(User userId){
//		ResponseStructure<List<Message>> structure = new ResponseStructure<>();
//		List<Message> recMessages = messageRepository.findByUser(userId);
//		
//		structure.setData(recMessages);
//		structure.setMessage("Message reterived sucessfully");
//		structure.setStatusCode(HttpStatus.OK.value());
//		return new ResponseEntity<ResponseStructure<List<Message>>>(structure, HttpStatus.OK);
//	}
	
//	public List<Message> getMessageByUser(Long userId){
//		User user = userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException("User Not Found "));
//		return messageRepository.findBySenderOrReceiver(user, user);
//	}
	
	
}


























