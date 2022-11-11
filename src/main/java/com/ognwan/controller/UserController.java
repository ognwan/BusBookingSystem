/**
 * 
 */
package com.ognwan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ognwan.exceptions.AlreadyExistsException;
import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.User;
import com.ognwan.serviceImplementation.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<String> add(@RequestBody User user) {
		try {
			userService.create(user);
			return ResponseEntity.created(null).build();
		} catch (AlreadyExistsException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/update-user/{userId}")
	public ResponseEntity<String> update(@RequestParam User user, long userId) {
		try {
			userService.update(user, userId);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.ok().body(e.getMessage());
		}
	}

	@GetMapping("/get-user/{userId}")
	public ResponseEntity<String> getById(@PathVariable long userId) {
		try {
			userService.getById(userId);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> delete(@PathVariable long userId) {
		userService.delete(userId);
		return ResponseEntity.ok().body("Success");

	}
}
