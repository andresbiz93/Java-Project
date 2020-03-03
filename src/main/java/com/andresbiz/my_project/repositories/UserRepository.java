package com.andresbiz.my_project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andresbiz.my_project.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByEmail(String email);
}
