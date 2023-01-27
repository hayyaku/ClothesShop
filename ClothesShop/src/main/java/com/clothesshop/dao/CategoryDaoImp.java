package com.clothesshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Category;

@Repository
public class CategoryDaoImp implements CategoryDao {
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			List<Category> list =ss.createQuery("from Category").list();
			ss.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public Category getById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			Category category =(Category) ss.createQuery("from Category where id = :id").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

}
