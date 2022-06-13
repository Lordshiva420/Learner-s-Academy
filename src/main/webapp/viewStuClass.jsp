<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.saveStudentsDB"%>
<%@page import="hibernate.saveClassDB"%>
<%@page import="hibernate.ListStudents"%>
<%@page import="hibernate.ListClasses "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th,td{
padding:1px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Dashboard.html">Back to Main Menu</a><br>
<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>

<h1>The Following students assigned to classes are listed</h1>
<%
//ArrayList<ListStudents> stulist= new ArrayList<ListStudents>();
//stulist=(ArrayList<ListStudents>) saveStudentsDB.studentDisplay();
ArrayList<ListClasses> clslist= new ArrayList<ListClasses>();
clslist=(ArrayList<ListClasses>) saveClassDB.classDisplay();
%>
<table>
<tr>
<th>Class Name</th>
<th>Student Name</th>
</tr>	
     <%
     String s=null;int i=1;
	for(ListClasses clas : clslist){
		if(clas.getCname()!=s)
		{
	       out.print("<tr>");	
	       out.print("<td>" + i+"."+clas.getCname() + "</td>");
		
	         for (ListStudents stu:clas.getListStudents()){
		
		        out.print("<tr><td></td>");	
		        out.print("<td>" + stu.getSname() + "</td>");
		        out.print("<tr>");
	           }
		}
		i++;
	 s=clas.getCname();
	//out.print(buf.toString());
}
     %>
</table>



</body>
</html>