package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.ActionDto;
import com.spring.dto.ActionDto.Status;
import com.spring.entity.User;
import com.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Iterable<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@RequestParam String id) {
		return userService.getUser(id);
	}

	@PostMapping
	public ActionDto create(@RequestBody User user) {
		User createdPost = userService.create(user);
		if (createdPost == null) {
			return new ActionDto(Status.FAIL, "update failed");
		}
		return new ActionDto(Status.SUCCESS, createdPost.getId());
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

	@DeleteMapping("/{id}")
	public ActionDto delete(@RequestParam String id) {
		userService.delete(id);
		return new ActionDto(Status.SUCCESS, "delete success");
	}

}
