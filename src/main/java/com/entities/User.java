package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	

	
	@Column(length = 500,unique = true)
	private String email;
	
	@Column(length = 500)
	private String password;
	
	@OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
	private List<Note> notes;

	public String getEmail() {
		return email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
