package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import hibernate.ListSubjects;
import hibernate.saveClassDB;
import hibernate.saveSubjectsDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddSubject extends HttpServlet {
	
	public void service(HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
		
        response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
		
		// Step 1: Get details , user has entered
		String Subname = request.getParameter("Subname");
				
		saveSubjectsDB.subjectInsert(Subname);
	
		RequestDispatcher  rd= getServletContext().getRequestDispatcher("/viewSubject.jsp");
       rd.forward(request, response); 
	}


}
