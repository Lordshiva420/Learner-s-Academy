<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveClassDB"%>
<%@page import="hibernate.ListTeachers"%>
<%@page import="hibernate.ListClasses "%>
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
<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>

<h1>The Following Teachers assigned to classes are listed</h1>
<%

ArrayList<ListClasses> clslist= new ArrayList<ListClasses>();
clslist=(ArrayList<ListClasses>) saveClassDB.classDisplay();
%>
<table>
<tr>
<th>Class Name</th>
<th>Teacher Name</th>
</tr>	
     <%
     String s=null;
	for(ListClasses clas : clslist){
		if(clas.getCname()!=s)
		{
	       out.print("<tr>");	
	       out.print("<td>" + clas.getCname() + "</td>");
		
	         for (ListTeachers tea:clas.getListTeachers() ){
		
		        out.print("<tr><td></td>");	
		        out.print("<td>" + tea.getTname() + "</td>");
		        out.print("<tr>");
	           }
		}
		
	 s=clas.getCname();
	//out.print(buf.toString());
}
     %>
</table>



</body>
</html>