<%@page import="hibernate. ListSubjects"%>
<%@page import="hibernate.hibernateCon"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="hibernate.ListTeachers"%>
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

<h1>Assign a subject to a teacher</h1>
<%
	SessionFactory sf  =hibernateCon.getfactory();
	Session hibernateSession = sf.openSession();
	List<ListTeachers> techears = hibernateSession.createQuery("from  ListTeachers").list();
	List< ListSubjects> subject = hibernateSession.createQuery("from  ListSubjects").list();
%>
<form action="assignTeacherToSub" method="post">
<table>
<tr>
<th>Teacher Name </th>
<th>subject Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (ListTeachers tea :techears){
	out.print("<option>" + tea.getTname());
	out.print("</option>");
	}
%>
</select>
</td>

<td>
<select name="subject">
<%
	for (ListSubjects sub : subject){
	out.print("<option>" + sub.getSubname());
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