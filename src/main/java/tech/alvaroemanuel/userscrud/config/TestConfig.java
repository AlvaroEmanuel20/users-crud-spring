package tech.alvaroemanuel.userscrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.alvaroemanuel.userscrud.entities.User;
import tech.alvaroemanuel.userscrud.repositories.UserRepository;

@Component
public class TestConfig implements ApplicationRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		User user1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.save(user1);
		userRepository.save(user2);
		
	}

}
