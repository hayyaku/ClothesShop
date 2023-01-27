package com.clothesshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Size;

@Repository
public class SizeDaoImp implements SizeDao {
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Size> getAllSize() {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			List<Size> sizes =  ss.createQuery("from Size").list();
			ss.getTransaction().commit();
			return sizes;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public Size getById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			Size size =  (Size) ss.createQuery("from Size where id = :id").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return size;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

}
