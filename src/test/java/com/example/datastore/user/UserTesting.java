package com.example.datastore.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.datastore.entity.User;
import com.example.datastore.repository.UserRepository;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserTesting {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = userRepo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void createNewUser() {
		User user = new User("Test", "test@gmail.com", "test");
		User saveUser = userRepo.save(user);
		
		assertThat(saveUser.getId()).isGreaterThan(0);
	}

}
