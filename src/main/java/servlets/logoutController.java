package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
    public logoutController() {
        super();
      
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		RequestDispatcher rd=null;
		if(session==null) {
			rd=request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			out.print("<center><span style='color:red'>Please login first.</span></center>");
			
		}
		else {
			session.invalidate();
			out.print("<center><h3>You have been logged out successfully.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;http://localhost:8080/LAproject/");
		}
	}

}
