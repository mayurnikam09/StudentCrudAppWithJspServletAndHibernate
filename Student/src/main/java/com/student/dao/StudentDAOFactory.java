package com.student.dao;

public class StudentDAOFactory {

	public static StudentDAO getInstance()
	{
		return new StudentDAOImpl();
	}
}
