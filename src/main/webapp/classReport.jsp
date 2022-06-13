<%@page import="hibernate.ListClasses"%>
<%@page import="hibernate.ListStudents"%>
<%@page import="hibernate.ListSubjects"%>
<%@page import="hibernate.ListTeachers"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="hibernate.hibernateCon"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th,td{
padding:10px;
}

</style>
</head>
<body>
<a href="Dashboard.html">Back to Main Menu</a><br>
<%String clas = request.getParameter("class");%>
<h1>Class Report for <%=clas%></h1>

<%
	SessionFactory sf  = hibernateCon.getfactory();
	Session hibernateSession = sf.openSession();
	List<ListClasses> classes = hibernateSession.createQuery("from ListClasses cl where cl.cname='" + clas + "'").list();
	ListClasses clasForReport = classes.get(0);
%>
<table>
<tr>
<th>Subjects </th>
<br>

</br>

<th>Teacher Name </th>
</tr>
<%	int i=1;
	for(ListSubjects subject: clasForReport.getListSubjects()){
		out.print("<tr>");	
		out.print("<td>" +i+"."+ subject.getSubname()  + "</td>");
		out.print("<td>" + getTeacherName(subject) + "</td>");
		out.print("</tr>");
		i++;
	}
%>
</table>
<%!
	public String getTeacherName(ListSubjects subject){
	ListTeachers teacher = subject.getListTeachers();
		String name;
		
		if(teacher != null){
			name=teacher.getTname();
			return name;
		}else{
			return "No Teacher assigned";
		}
}
%>
<table>
<br>
<tr>
<th>Students in <%=clas%></th>
</tr>
<%
int n=1;
	for(ListStudents student : clasForReport.getListStudents()){
		out.print("<tr>");
		out.print("<td>"+n+"."+ student.getSname()  + " " + student.getEmail() +" " + student.getPhone()+"</td>");
		out.print("</tr>");
		n++;
	}
%>
</table>
</br>
</body>
</html>