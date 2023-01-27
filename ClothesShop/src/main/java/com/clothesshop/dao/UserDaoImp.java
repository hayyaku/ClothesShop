package com.clothesshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.User;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User getByUserName(String userName) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			User user = (User) ss.createQuery("from User where userName = :username").setParameter("username", userName).uniqueResult();
			ss.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public void save(User u) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(u);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		
	}

	@Override
	public User getByPhone(String phone) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			User user = (User) ss.createQuery("from User where phone = :phone").setParameter("phone", phone).uniqueResult();
			ss.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			User user = (User) ss.createQuery("from User where email = :email").setParameter("email", email).uniqueResult();
			ss.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

}
