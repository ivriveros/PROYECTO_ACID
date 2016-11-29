package com.ivan.users.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivan.users.model.Users;

@Controller
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	Map<Integer, Users> usrData = new HashMap<Integer, Users>();
	
	@RequestMapping(value = UsersURIConstants.ACID_USERS, method = RequestMethod.GET)
	public @ResponseBody Users getAcidUsers() { // Metodo para agregar usuario Ivan Riveros
		logger.info("Start getAcidUsers");
		Users usr = new Users();
		usr.setId(1);
		usr.setUsername("Ivan Riveros");
                usr.setImage("C:\\Users\\ivriv\\Pictures\\test.png");
		usrData.put(1, usr);
		return usr;
	}
	
	@RequestMapping(value = UsersURIConstants.GET_USERS, method = RequestMethod.GET)
	public @ResponseBody Users getUsers(@PathVariable("id") int usrId) { // Metodo para consultar usuario por ID
		logger.info("Start getUsers. ID="+usrId);
		
		return usrData.get(usrId);
	}
	
	@RequestMapping(value = UsersURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
	public @ResponseBody List<Users> getAllUsers() { // Metodo para consultar todos los usuarios
		logger.info("Start getAllUsers.");
		List<Users> usrs = new ArrayList<Users>();
		Set<Integer> usrIdKeys = usrData.keySet();
		for(Integer i : usrIdKeys){
			usrs.add(usrData.get(i));
		}
		return usrs;
	}
	
	@RequestMapping(value = UsersURIConstants.CREATE_USERS, method = RequestMethod.POST)
	public @ResponseBody Users createUsers(@RequestBody Users usr) { // Metodo para crear usuarios
		logger.info("Start createUsers.");
//		usr.setCreatedDate(new Date());
		usrData.put(usr.getId(), usr);
		return usr;
	}
	
	@RequestMapping(value = UsersURIConstants.DELETE_USERS, method = RequestMethod.PUT)
	public @ResponseBody Users deleteUsers(@PathVariable("id") int usrId) { // Metodo para eliminar usuarios por ID
		logger.info("Start deleteUsers.");
		Users usr = usrData.get(usrId);
		usrData.remove(usrId);
		return usr;
	}

}
