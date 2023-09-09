package tech.alvaroemanuel.userscrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.alvaroemanuel.userscrud.entities.User;
import tech.alvaroemanuel.userscrud.repositories.UserRepository;
import tech.alvaroemanuel.userscrud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public User findById(Long id) throws ResourceNotFoundException {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return user;
	}
	
	public User insert(User user) {
		return this.userRepository.save(user);
	}
	
	public User update(Long id, User newData) throws ResourceNotFoundException {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		user.setEmail(newData.getEmail());
		user.setName(newData.getName());
		user.setPassword(newData.getPassword());
		user.setPhone(newData.getPhone());
		
		return this.userRepository.save(user);
	}
	
	public boolean delete(Long id) throws ResourceNotFoundException {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		this.userRepository.delete(user);
		return true;
	}
	
}
