package com.testing;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

//import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Note;
import com.entities.User;

public class App {
public static void main(String[] args) {
	SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	User user = session.get(User.class, 2);
	List<Note> notes = new ArrayList<Note>();
	notes.add(new Note("What is Python Language?","Java is a High level Programming General Purpose language",user));
	user.setNotes(notes);
	session.save(user);
	
//	session.save(new User("subham@gmail.com","python"));
	
	
	session.getTransaction().commit();
	session.close();
	factory.close();
	
	
	
	
}
}
