package org.jsp.springbootecholink.repository;

import java.util.List;

import org.jsp.springbootecholink.model.Message;
import org.jsp.springbootecholink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	  
//	List<Message> findByUser(User userId);
}
