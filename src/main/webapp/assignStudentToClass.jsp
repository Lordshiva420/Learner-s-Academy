<%@page import="hibernate.ListClasses"%>
<%@page import="hibernate.hibernateCon"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="hibernate.ListStudents"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Dashboard.html">Back to Main Menu</a><br>

<h1>Assign a Student to a Class</h1>
<%
	SessionFactory sf  =hibernateCon.getfactory();
	Session hibernateSession = sf.openSession();
	List<ListStudents> students = hibernateSession.createQuery("from  ListStudents").list();
	List<ListClasses> classes = hibernateSession.createQuery("from  ListClasses").list();
%>
<form action="assignStudent" method="post">
<table>
<tr>
<th>Student Name </th>
<th>Class Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (ListStudents student : students){
	out.print("<option>" + student.getSname());
	out.print("</option>");
	}
%>
</select>
</td>

<td>
<select name="class">
<%
	for (ListClasses clas : classes){
	out.print("<option>" + clas.getCname());
	out.print("</option>");
	}
%>
</select>
</td>
</tr>
</table>
<input type="submit" value="Submit">
</form>

</body>
</html>