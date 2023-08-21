package com.servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.entities.User;
import com.helper.HibernateConfig;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		
		Session session = HibernateConfig.getSession();
//		check if user with this email exists
		CriteriaBuilder cb= session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root).where(cb.equal(root.get("email"), email));
		Query query = session.createQuery(cq);
		Object u = query.getResultList();
		User user = null;
		if(!u.toString().equals("[]")) {
			user = (User)query.getSingleResult();
			
//			hashing current password and comparing with original password
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
				messageDigest.update(password.getBytes());
				password = new String(messageDigest.digest());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user.getPassword().equals(password)) {
				
				System.out.println("Authenticated User");
				request.setAttribute("user", "success");
				HttpSession s = request.getSession();
				s.setAttribute("user_id", user.getUser_id());
				s.setAttribute("user_email", user.getEmail());
			}
			else {
				System.out.println("Not Authenticated");
				request.setAttribute("user", "error");
			}
		}
		else {
			request.setAttribute("user", "false");
		}
		

	
		
		
		
		session.close();
		RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
		dispatch.forward(request, response);
	}

}
