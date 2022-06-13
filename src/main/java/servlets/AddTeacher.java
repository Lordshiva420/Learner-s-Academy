package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import hibernate.saveSubjectsDB;
import hibernate.saveTeachersDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddTeacher extends HttpServlet{
	

	public void service(HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
		
        response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
		
		// Step 1: Get details , user has entered
		String Tname = request.getParameter("Tname");
				
		saveTeachersDB.teacherInsert(Tname);
	
		RequestDispatcher  rd= getServletContext().getRequestDispatcher("/viewTeachers.jsp");
       rd.forward(request, response); 
	}


}
