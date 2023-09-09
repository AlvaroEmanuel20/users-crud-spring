package tech.alvaroemanuel.userscrud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.alvaroemanuel.userscrud.entities.User;
import tech.alvaroemanuel.userscrud.services.UserService;
import tech.alvaroemanuel.userscrud.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired	
	private UserService userService;
	
	@GetMapping("/hello")
    public String hello() {
      return "Users Management API";
    }
	
	@GetMapping("/")
    public List<User> findAll() {
      return this.userService.findAll();
    }
	
	@GetMapping("/{id}")
    public User findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
      return this.userService.findById(id);
    }
	
	@PostMapping("/")
    public User insert(@RequestBody User user) {
      return this.userService.insert(user);
    }
	
	@PutMapping("/{id}")
    public User update(@PathVariable(value = "id") Long id, @RequestBody User user) throws ResourceNotFoundException {
      return this.userService.update(id, user);
    }
	
	@DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
      return this.userService.delete(id);
    }
}
