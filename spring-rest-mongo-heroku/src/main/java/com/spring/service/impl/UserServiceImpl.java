package com.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.exception.NotFoundException;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new NotFoundException("User", "id", id);
		}
		return user.get();
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		String id = user.getId();
		Optional<User> existUser = userRepository.findById(id);
		if (!existUser.isPresent()) {
			throw new NotFoundException("User", "id", id);
		}

		return mergePost(existUser.get(), user);
	}

	public User mergePost(User existUser, User newUser) {
		if (newUser.getUsername() != null) {
			existUser.setUsername(newUser.getUsername());
		}

		if (newUser.getPassword() != null) {
			existUser.setPassword(newUser.getPassword());
		}

		if (newUser.getName() != null) {
			existUser.setName(newUser.getName());
		}

		if (newUser.getPhone() != null) {
			existUser.setPhone(newUser.getPhone());
		}

		if (newUser.getEmail() != null) {
			existUser.setEmail(newUser.getEmail());
		}
		return newUser;
	}

	@Override
	public void delete(String id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new NotFoundException("User", "id", id);
		}
		userRepository.delete(user.get());
	}

}
