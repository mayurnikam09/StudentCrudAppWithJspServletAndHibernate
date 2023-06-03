<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="background-color: green;text-align: center;">---UPDATE DATA---</h1>
	<form action="UpdateData" style="text-align: center;">
	Student Id:<input type="text" value="${requestScope.stud.id}" readonly="readonly" name="id">
	<br><br>
	Student Name:<input type="text" value="${requestScope.stud.name}" name="name">
	<br><br>
	Student Marks:<input type="text" value="${requestScope.stud.marks}" name="marks">
	<br><br>
	Student City:<input type="text" value="${requestScope.stud.city}" name="city">
	<br><br>
	Course:<input type="text" value="${requestScope.stud.course}" name="course">
	<br><br>
	Gender:<input type="text" value="${requestScope.stud.gender }" name="gender">
	<br><br>
	<input type="submit" value="UPDATE">
</form>
</body>
</html>