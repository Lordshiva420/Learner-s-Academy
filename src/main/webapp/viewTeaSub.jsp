<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveTeachersDB"%>
<%@page import="hibernate.ListTeachers"%>
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
<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>

<h1>The Following Subjects assigned to Teachers are listed</h1>
<%

ArrayList<ListTeachers> tealist= new ArrayList<ListTeachers>();
tealist=(ArrayList<ListTeachers>) saveTeachersDB.teacherDisplay();
%>
<table>
<tr>
<th>Teacher Name</th>
<th>Subject Name</th>
</tr>	
     <%
     String s=null;int i=1;
 	for(ListTeachers tea : tealist){
 		if(tea.getTname()!=s)
 		{
 	       out.print("<tr>");	
 	       out.print("<td>" + i+"."+tea.getTname()+ "</td>");
 		
 	         for (ListSubjects sub:tea.getListSubjects()){
 		
 		        out.print("<tr><td></td>");	
 		        out.print("<td>" + sub.getSubname() + "</td>");
 		        out.print("<tr>");
 	           }
 		}
 		i++;
 	 s=tea.getTname();
 	//out.print(buf.toString());
 }
     %>
</table>



</body>
</html>