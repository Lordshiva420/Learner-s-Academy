<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveSubjectsDB"%>
<%@page import="hibernate.ListSubjects"%>
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

<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>

<h1>The Following Subjects are listed</h1>
<%
ArrayList<ListSubjects> sublist= new ArrayList<ListSubjects>();
sublist=(ArrayList<ListSubjects>) saveSubjectsDB.subjectDisplay();
%>
<table>
<tr>
<th>Sub id</th>
<th>Subject Name</th>
</tr>	
	<% 
		for(ListSubjects sub:sublist){
			out.print("<tr>");	
			out.print("<td>" + sub.getSubid() + "</td>");
			out.print("<td>" + sub.getSubname() + "</td>");
			
				
			}
		%>
</table>
</body>
</html>