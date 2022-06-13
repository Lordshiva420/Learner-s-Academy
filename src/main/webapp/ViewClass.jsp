<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveClassDB"%>
<%@page import="hibernate.ListClasses"%>
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
<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>
<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>
<h1>The Following Classes are listed</h1>
<%
	
ArrayList<ListClasses> clslist= new ArrayList<ListClasses>();
clslist=(ArrayList<ListClasses>) saveClassDB.classDisplay();

%>
<table>
<tr>
<th>Class Id</th>
<th>Class Name</th>
</tr>	
	<%		
	for(ListClasses cls:clslist){
			out.print("<tr>");	
			out.print("<td>" +cls.getCid() + "</td>");
			out.print("<td>" + cls.getCname() + "</td>");
			out.print("<tr>");
			
			}
			
		
	%>
</table>
</body>
</html>