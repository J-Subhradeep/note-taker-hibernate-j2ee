package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entities.Note;
import com.entities.User;
import com.helper.HibernateConfig;

/**
 * Servlet implementation class AddNoteServlet
 */
public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		
		Session session = HibernateConfig.getSession();
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		List<Note> notes = new ArrayList<Note>();
		Note note = new Note(title,content,user);
		
		notes.add(note);
		user.setNotes(notes);
		session.save(user);
		
		
		session.getTransaction().commit();
		session.close();
		
		response.sendRedirect("index.jsp");
		
	}

}
