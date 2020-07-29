package com.examplelast.demo.last;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/demo") // This means URL's start with /demo 
public class MainController {

	@Autowired // This means to get the bean called userRepository
	private UserRepository userRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@GetMapping(path = "/all/{id}")
	public  Optional<User> getuser(@PathVariable long id) {

		return userRepository.findById(id);

	}

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestBody User n) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		userRepository.save(n);
		return "Saved";
	}

	@DeleteMapping("/del/{id}")
	public @ResponseBody String deleteUser(@PathVariable Long id) {
		// Todo todo = todoService.deleteById(id);
		userRepository.deleteById(id);
		return "Deleted";

	}

	@PutMapping("/upd/{id}")
	public @ResponseBody String updateTodo(@PathVariable Long id, @RequestBody User todo) {

		if (userRepository.findById(id) != null) {
			userRepository.saveAndFlush(todo);
		} else {

			return "Error";
		}
		return "Updated";
	}

}
