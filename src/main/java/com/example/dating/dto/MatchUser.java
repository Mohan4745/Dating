package com.example.dating.dto;

import java.util.List;

import com.example.dating.util.UserGender;

import lombok.Data;
@Data
public class MatchUser {
	
	
	private int id;
	private String name;
	private String email;
	private Long phone;
	private int age;
	private UserGender gender;
	private List<String> interests;
	
	private int ad;
	private int imc;

}
