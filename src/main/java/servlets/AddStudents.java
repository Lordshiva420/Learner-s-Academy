package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import hibernate.saveStudentsDB;
import hibernate.saveSubjectsDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudents extends HttpServlet{
public void service(HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
		
        response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
		
		// Step 1: Get details , user has entered
		String stuname = request.getParameter("Stuname");
		String stuemail = request.getParameter("Stuemail");
		long stuphone = Long.parseLong(request.getParameter("Stuphone"));
				
		saveStudentsDB.studentInsert(stuname,stuemail,stuphone);
	
		RequestDispatcher  rd= getServletContext().getRequestDispatcher("/viewStudent.jsp");
       rd.forward(request, response); 

}
}
