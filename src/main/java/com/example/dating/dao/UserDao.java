package com.example.dating.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dating.entity.User;
import com.example.dating.repository.UserRepository;
import com.example.dating.util.UserGender;

@Repository
public class UserDao {

	
	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public List<User>findAllMale() {
		return userRepository.findByGender(UserGender.MALE);
	
	}

	public List<User> findAllFemale() {
			return userRepository.findByGender(UserGender.FEMALE);
	}

	public Optional<User> findById(int id) {
	 return	userRepository.findById(id);
	}
}
