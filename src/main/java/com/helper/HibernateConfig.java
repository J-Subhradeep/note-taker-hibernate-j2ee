package com.helper;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Note;
import com.entities.User;

public class HibernateConfig {
	
	private static Configuration cfg = new Configuration();
	private static Session session;
	public static SessionFactory getSessionFactory() {
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Note.class);
		return cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		
	}
	public static Session getSession() {
		
		session = getSessionFactory().openSession();
		return session;
	}
	
}
