package com.example.dating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dating.entity.User;
import com.example.dating.util.UserGender;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByGender(UserGender male);

}
