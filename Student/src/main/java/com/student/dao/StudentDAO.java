package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDAO {

	void saveStudent(Student stud);
	
	boolean deleteStudent(int id);
	
	List<Student> getAllStudent();
	
	public Student updateElementById(int id);
	
	public Student updateAllInfo(Student stud);
}
