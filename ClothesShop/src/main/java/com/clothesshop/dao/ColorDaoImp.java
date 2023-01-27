package com.clothesshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Color;

@Repository
public class ColorDaoImp implements ColorDao {
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Color> getAllColor() {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			List<Color> colors =  ss.createQuery("from Color").list();
			ss.getTransaction().commit();
			return colors;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public Color getById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			Color color = (Color) ss.createQuery("from Color where id = :id").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return color;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public void save(Color color) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(color);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		
	}
}

