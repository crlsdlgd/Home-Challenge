package com.kruger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.models.User;
import com.kruger.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User getUserById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User getOrCreateUser(String email) {
		User user = repository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setEmail(email);
			user.setRole("CLIENT");
			user = repository.save(user);
		}
		return user;
	}

	public User updateUser(User user) {
        User existingUser = this.getUserById(user.getId());
        if (existingUser == null) {
            throw new EntityNotFoundException("User with ID " + user.getId() + " not found");
        }
        return repository.save(user);
    }

}
