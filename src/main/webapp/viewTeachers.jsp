<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveTeachersDB"%>
<%@page import="hibernate.ListTeachers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th,td{
padding:10px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Dashboard.html">Back to Main Menu</a><br>
<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>
<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>
<h1>The Following teachers are listed</h1>
<%
ArrayList<ListTeachers> tealist= new ArrayList<ListTeachers>();
tealist=(ArrayList<ListTeachers>) saveTeachersDB.teacherDisplay();
%>
<table>
<tr>
<th>Tid</th>
<th>Teacher Name</th>
</tr>	
	<%
		for(ListTeachers tea:tealist){
			out.print("<tr>");	
			out.print("<td>" + tea.getTid() + "</td>");
			out.print("<td>" + tea.getTname()+ "</td>");
			
				
			}
		%>
</table>
</body>
</html>