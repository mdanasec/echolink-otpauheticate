package org.jsp.springbootecholink.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "senderId", nullable = false)
	private User sender;

	@ManyToOne
	@JoinColumn(name = "receiverId", nullable = false)
	private User receiver;

	@Column(nullable = false)
	private String content; 

	@Column(nullable = false)
	private LocalDateTime timestamp = LocalDateTime.now();

	public Message(long id, User sender, User receiver, String content, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.timestamp = timestamp;
	}
	
	

}
