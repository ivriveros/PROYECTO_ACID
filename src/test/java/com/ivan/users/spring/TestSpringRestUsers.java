package com.ivan.users.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ivan.users.controller.UsersURIConstants;
import com.ivan.users.model.Users;

public class TestSpringRestUsers {

	public static final String SERVER_URI = "http://localhost:8080/AcidLabsUsers";

	public static void main(String args[]) {

		testGetAcidUsers();
		System.out.println("*****");
		testCreateUsers();
		System.out.println("*****");
		testGetUsers();
		System.out.println("*****");
		testGetAllUsers();
	}
	
	
	private static void testGetAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> usrs = restTemplate.getForObject(SERVER_URI+UsersURIConstants.GET_ALL_USERS, List.class);
		System.out.println(usrs.size());
		for(LinkedHashMap map : usrs){
			System.out.println("ID="+map.get("id")+",Name="+map.get("username")+",Image="+map.get("image"));;
		}
	}
	
	private static void testCreateUsers() {
		RestTemplate restTemplate = new RestTemplate();
		Users usr = new Users();
		usr.setId(1);usr.setUsername("Romina Rosasr");
		Users response = restTemplate.postForObject(SERVER_URI+UsersURIConstants.CREATE_USERS, usr, Users.class);
		printUsrData(response);
	}
	
	private static void testGetUsers() {
		RestTemplate restTemplate = new RestTemplate();
		Users usr = restTemplate.getForObject(SERVER_URI+"/rest/user/1", Users.class);
		printUsrData(usr);
	}

	private static void testGetAcidUsers() {
		RestTemplate restTemplate = new RestTemplate();
		Users usr = restTemplate.getForObject(SERVER_URI+UsersURIConstants.ACID_USERS, Users.class);
		printUsrData(usr);
	}
	
	public static void printUsrData(Users usr){
		System.out.println("ID="+usr.getId()+",Name="+usr.getUsername()+",Image="+usr.getImage());
	}

}
