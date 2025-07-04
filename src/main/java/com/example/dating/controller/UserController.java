package com.example.dating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dating.entity.User;
import com.example.dating.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
		@GetMapping("/user/gender/male")
		public ResponseEntity<?> findAllMale(){
			return userService.findAllMale();
		}


		@GetMapping("/user/gender/female")
		public  ResponseEntity<?> findAllFemale(){
			return userService.findAllFemale();
		}
		
		@GetMapping("/user/match/{id}/{top}")
		public ResponseEntity<?> findMatch(@PathVariable int id,@PathVariable int top){
			return userService.findMatch(id,top);
		}
		
		@GetMapping("/users/search/name/{letters}")
		public ResponseEntity<?> searchByName(@PathVariable String letters){
			return userService.searchByName(letters);
		}
		
		@GetMapping("/users/search/email/{letters}")
		public ResponseEntity<?> searchByEmail(@PathVariable String letters){
		return	userService.searchByEname(letters);
		}
}