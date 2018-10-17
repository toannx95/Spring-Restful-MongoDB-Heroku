package com.spring.service;

import com.spring.entity.User;

public interface UserService {

	Iterable<User> getAllUsers();

	User getUser(String id);

	User create(User user);

	User update(User user);

	void delete(String id);
}
