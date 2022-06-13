<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveStudentsDB"%>
<%@page import="hibernate.ListStudents"%>
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

<h1>The Following Students are listed</h1>
<%
	
ArrayList<ListStudents> stulist= new ArrayList<ListStudents>();
stulist=(ArrayList<ListStudents>) saveStudentsDB.studentDisplay();

%>
<table>
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Student Email</th>
<th>Student Phno:</th>
</tr>	
	<%		
	for(ListStudents stu:stulist){
			out.print("<tr>");	
			out.print("<td>" + stu.getSid() + "</td>");
			out.print("<td>" + stu.getSname() + "</td>");
			out.print("<td>" + stu.getEmail() + "</td>");
			out.print("<td>" + stu.getPhone()  + "</td>");
			
				
			}
			
		
	%>
</table>
</body>
</html>