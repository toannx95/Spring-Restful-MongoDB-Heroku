package com.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
