package com.student.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.student.model.Student;
import com.student.util.HibernateUtil;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public void saveStudent(Student stud) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		if(stud!=null)
		{
			session.save(stud);
		}
		tx.commit();
		System.out.println("Data Saved!!");
		session.close();
	}

	@Override
	public boolean deleteStudent(int id) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Student stud=session.get(Student.class, id);
		session.delete(stud);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public List<Student> getAllStudent() {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);
		List<Student>list=criteria.list();
		
		System.out.println("Data Read");
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public Student updateElementById(int id) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Student stud=(Student)session.load(Student.class, id);
		
		//session.update(stud);
		tx.commit();
		//session.close();
		return stud;
	}

	@Override
	public Student updateAllInfo(Student stud) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.update(stud);
		tx.commit();
		System.out.println("All Data Updated!!");
		return stud;
	}	
	
	
}
