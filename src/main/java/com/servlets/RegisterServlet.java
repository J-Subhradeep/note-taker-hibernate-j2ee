package com.servlets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.io.IOException;

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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String email = request.getParameter("email");
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			password = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(password+" "+email);
		
		Session session  = HibernateConfig.getSession();
//		System.out.println(session);
//		session.save(new User(email,password));
		
		
//		checking if user exist with this email
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root).where(cb.equal(root.get("email"), email));
		Query query = session.createQuery(cq);
		List<User> u = query.getResultList();
		if(u.isEmpty()) { 
			
//			if not exist
			session.save(new User(email,password));
			request.setAttribute("user", "created");
		}
		else {
			request.setAttribute("user", "exists");
		}
		
		
		session.close();
		
		RequestDispatcher dispatch = request.getRequestDispatcher("register.jsp");
		dispatch.forward(request, response);
	}

}
