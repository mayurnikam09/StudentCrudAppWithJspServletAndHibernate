<%@page import="com.student.model.Student"%>
<%@page import="com.student.dao.StudentDAOImpl"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Student Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<%!StudentDAO dao;

	public void jspInit() {

		dao=new StudentDAOImpl();

	}%>
	
	<%
	List<Student>list=dao.getAllStudent();
	Iterator<Student>itr=list.iterator();
	
	application.setAttribute("list", list);
	%>
	
    <b><h1 style="background-color: coral;color: black;">----Student Details----</h1></b>
	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Name</th> 
				<th>Marks</th>
				<th>City</th>
				<th>Course</th>
				<th>Gender</th>
				<th>Update Student</th>
				<th>Delete Student</th>
			</tr>
			<c:forEach var="stud" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${stud.id}"></c:out></td>
					<td><c:out value="${stud.name}"></c:out></td>
					<td><c:out value="${stud.marks}"></c:out></td>
					<td><c:out value="${stud.city}"></c:out></td>
					<td><c:out value="${stud.course}"></c:out></td>
					<td><c:out value="${stud.gender}"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/UpdateServlet?id=${stud.id}" class="btn btn-primary">UPDATE</a></td>
					<td><a href="${pageContext.request.contextPath}/DeleteServlet?id=${stud.id}" class="btn btn-danger">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
		<b><a href="Student.html" class="previous">&#8249 Back</a></b>
	</div>
</body>
</html>