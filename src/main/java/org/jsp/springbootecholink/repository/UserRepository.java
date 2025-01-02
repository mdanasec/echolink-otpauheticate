package org.jsp.springbootecholink.repository;

import org.jsp.springbootecholink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String name);
	User findByEmail(String email);
	
}
