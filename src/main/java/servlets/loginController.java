package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    public loginController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		
		loginController loginObj=new loginController();
		try {
			if(loginObj.userLogin(username, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60);
				//response.sendRedirect("index.html");

				rd=request.getRequestDispatcher("/Dashboard.html");
				rd.forward(request, response);
				
			}
			
			
			
			
		} catch (Exception e) {
			rd=request.getRequestDispatcher("login.html");
			//out.print(username+" "+password);
		rd.include(request, response);	
		out.print("<center><span style='color:red'>"+e.getMessage()+"</span></center>");
		}
	}

	boolean userLogin(String username, String password) throws Exception {
		boolean bool=false; 
		if(!username.isEmpty() && !password.isEmpty()){
			if(username.matches("shiva") && password.matches("12345")) {
				
				bool=true;
				return bool;
			}
			else {throw new Exception("Invalid Credentials");}
		}
		else {throw new Exception("username, password cannot be null");}
		
		
		
	
	}


	


}
