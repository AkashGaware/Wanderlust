package com.Wanderlust.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Wanderlust.Model.User;

public class UserDao {
	public static void addUser(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static boolean isUniqueMail(String email) {
		Session session = HibernateUtil.getSession();
		Query<User> query = session.createQuery("from User where email = :e");
		query.setParameter("e", email);
		User user = query.uniqueResult();
		
		if(user==null)
			return true;
		else
			return false;
	}
	
	public static User getCurrentUser(String username) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("from User where email = :e");
		query.setParameter("e", username);
		User user = query.uniqueResult();
		
		if(user == null)
			return null;
		else
			return user;
	}
	
	public static void updateUser(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void deleteUser(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.remove(user);
		session.getTransaction().commit();
		session.close();
	}
}
