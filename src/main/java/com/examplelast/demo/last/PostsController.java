package com.examplelast.demo.last;

import java.util.List;

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

@Controller // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/posts")
public class PostsController {

	
	  @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private PostRepo postRepository;

		 @GetMapping(path="/all")
		  public @ResponseBody Iterable<Posts> getAllUsers() {
		    // This returns a JSON or XML with the users
		    return postRepository.findAll();
		  }
	 

	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewPost (@RequestBody Posts n) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request
		  postRepository.save(n);
	    return "Saved";
	  }
		
		@DeleteMapping("/del/{id}")
		public @ResponseBody String deletePost(
				 @PathVariable Long id){
			//Todo todo = todoService.deleteById(id);
			postRepository.deleteById(id);
		    return "Deleted";

		}
		
		
		@PutMapping("/upd/{id}")
		public @ResponseBody String updateTodo(@PathVariable Long id, @RequestBody Posts todo){
			
			 if (postRepository.findById(id) != null) {
				 postRepository.saveAndFlush(todo);}
			 else {
				 
				 return "Error";
			 }
			return "Updated";
		}
		
	 
}