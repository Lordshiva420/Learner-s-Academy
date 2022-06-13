package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.ListClasses;

import hibernate.hibernateCon;
import hibernate.saveClassDB;
import hibernate.saveSubjectsDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/addClass")
public class AddClass extends HttpServlet {

	public void service(HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
			
	         response.setContentType("text/html");
	         
			PrintWriter out = response.getWriter();
			
			// Step 1: Get details , user has entered
			String cname = request.getParameter("cname");
					
			
			saveClassDB.classInsert(cname);
			
			RequestDispatcher  rd= getServletContext().getRequestDispatcher("/ViewClass.jsp");
	        rd.forward(request, response); 
		}

	}


