<%@page import="hibernate.ListClasses"%>
<%@page import="hibernate.hibernateCon"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="hibernate.ListSubjects"%>
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

<h1>Assign a Subject to a Class</h1>
<%
	SessionFactory sf  =hibernateCon.getfactory();
	Session hibernateSession = sf.openSession();
	List<ListSubjects> subjects = hibernateSession.createQuery("from  ListSubjects").list();
	List<ListClasses> classes = hibernateSession.createQuery("from  ListClasses").list();
%>
<form action="assignSubject" method="post">
<table>
<tr>
<th>Subject Name </th>
<th>Class Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (ListSubjects sub :subjects){
	out.print("<option>" + sub.getSubname());
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