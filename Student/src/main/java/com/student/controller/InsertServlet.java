package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.model.Student;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		double marks=Double.parseDouble(request.getParameter("marks"));
		String city=request.getParameter("city");
		String course=request.getParameter("course");
		String gender=request.getParameter("gender");
		
		
		Student stud=new Student();
		stud.setName(name);
		stud.setMarks(marks);
		stud.setCity(city);
		stud.setCourse(course);
		stud.setGender(gender);
		
		dao.saveStudent(stud);
		request.getRequestDispatcher("jsp/DisplayStud.jsp").forward(request, response);
	}

}
