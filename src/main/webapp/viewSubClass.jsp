<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveClassDB"%>
<%@page import="hibernate.ListSubjects"%>
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
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>

<h1>The Following Subjects  assigned to classes are listed</h1>
<%

ArrayList<ListClasses> clslist= new ArrayList<ListClasses>();
clslist=(ArrayList<ListClasses>) saveClassDB.classDisplay();
%>
<table>
<tr>
<th>Class Name</th>
<th>Subject Name</th>
</tr>	
     <%
     String s=null;
	for(ListClasses clas : clslist){
		if(clas.getCname()!=s)
		{
	       out.print("<tr>");	
	       out.print("<td>" + clas.getCname() + "</td>");
		
	         for (ListSubjects sub:clas.getListSubjects() ){
		
		        out.print("<tr><td></td>");	
		        out.print("<td>" + sub.getSubname() + "</td>");
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