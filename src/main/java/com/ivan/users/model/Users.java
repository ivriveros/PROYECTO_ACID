package com.ivan.users.model;

import java.io.Serializable;

public class Users implements Serializable { // Entidad para los Getter/Setter

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054384646309740347L;
	
	private int id; 
	private String username;
        private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
        
        public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
