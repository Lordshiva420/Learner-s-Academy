package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.ListClasses;
import hibernate.ListSubjects;
import hibernate.ListTeachers;
import hibernate.hibernateCon;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AssignTeacherToSub extends HttpServlet {
	
private static final long serialVersionUID = 1L;
    
	Transaction tx=null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String tname = request.getParameter("name");
		String subject = request.getParameter("subject");
				
			try {
			SessionFactory factory = hibernateCon.getfactory();
			Session session = factory.openSession();
			 tx = session.beginTransaction();
			String hql_teacher= "from ListTeachers  where tname='" + tname + "'";
			List<ListTeachers> tea = session.createQuery(hql_teacher).list();
			ListTeachers x=tea.get(0);
			System.out.println("hello"+x);
			String qryString3 = "update ListSubjects  s set s.ListTeachers =:n where s.Subname=:sn";
	        Query query3 = session.createQuery(qryString3);
	        query3.setParameter("n", tea.get(0));
			query3.setParameter("sn",subject );
	        query3.executeUpdate();
		
			tx.commit();
			session.close();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewTeaSub.jsp");
	        dispatcher.forward(request, response); 
		   }
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
		
	}

}
