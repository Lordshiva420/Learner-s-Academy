package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.RequestDispatcher;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.ListClasses;
import hibernate.hibernateCon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AssignStudentToClass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	Transaction tx=null;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String sname = request.getParameter("name");
		String classes = request.getParameter("class");
				
			try {
			SessionFactory factory = hibernateCon.getfactory();
			Session session = factory.openSession();
			 tx = session.beginTransaction();
			String hql_classes= "from ListClasses where cname='" + classes + "'";
			List<ListClasses> clas = session.createQuery(hql_classes).list();
			ListClasses x=clas.get(0);
			System.out.println("hello"+x);
			String qryString3 = "update ListStudents  s set s.ListClasses=:n where s.Sname=:sn";
	        Query query3 = session.createQuery(qryString3);
	        query3.setParameter("n", clas.get(0));
			query3.setParameter("sn",sname );
	        query3.executeUpdate();
		
			tx.commit();
			session.close();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewStuClass.jsp");
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
