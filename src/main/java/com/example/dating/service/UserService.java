package com.example.dating.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dating.dao.UserDao;
import com.example.dating.dto.MatchUser;
import com.example.dating.entity.User;
import com.example.dating.util.UserGender;
import com.example.dating.util.UserSorting;

@Service
public class UserService {

	
		@Autowired
		UserDao userDao;

		public ResponseEntity<?> saveUser(User user) {
			User savedUser = userDao.saveUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		}

		public ResponseEntity<?> findAllMale() {
			List<User> allMale = userDao.findAllMale();
			if(allMale.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no male users found");
			}
			else {
			return ResponseEntity.status(HttpStatus.OK).body(allMale);
			}
		}

		public ResponseEntity<?> findAllFemale() {
			List<User> allFemale = userDao.findAllFemale();
			
			if(allFemale.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no female user found");
			}
				return ResponseEntity.status(HttpStatus.OK).body(allFemale);
		}

		public ResponseEntity<?> findMatch(int id, int top) {
			Optional<User> optional = userDao.findById(id);
			if(optional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
			}
			User user= optional.get();
			List<User> users=new ArrayList<>();
			if(user.getGender().equals(UserGender.MALE)) {
				users =userDao.findAllFemale();
				
			}else {
				users =userDao.findAllMale();
			}
			List<MatchUser> matchUsers =new ArrayList<>();
			for(User u: users) {
				MatchUser mu=new MatchUser();
				mu.setId(u.getId());
				mu.setName(u.getName());
				mu.setEmail(u.getEmail());
				mu.setPhone(u.getPhone());
				mu.setAge(u.getAge());
				mu.setGender(u.getGender());
				mu.setInterests(u.getIntersts());
				
				mu.setAd(Math.abs(u.getAge()-user.getAge()));
				
				List<String> i1=u.getIntersts();
				List<String>i2=user.getIntersts();
				int ic=0;
				for(String s:i1) {
					if(i2.contains(s))
						ic++;
				}
				mu.setImc(ic);
				
				matchUsers.add(mu);
				
			}
			System.out.println(matchUsers);
			UserSorting us = new UserSorting();
			Collections.sort(matchUsers,us);
			ArrayList<MatchUser> res =new ArrayList<>();
			for(MatchUser mu : matchUsers) {
				if(top==0) {
					break;
				}
				res.add(mu);
				top--;
				
			}
		return ResponseEntity.status(HttpStatus.OK).body(res);	
		}
}
