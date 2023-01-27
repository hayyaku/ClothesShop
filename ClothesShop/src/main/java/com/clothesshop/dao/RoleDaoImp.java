package com.clothesshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Role;

@Repository
public class RoleDaoImp implements RoleDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Role getByRoleName(String roleName) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			Role role = (Role) ss.createQuery("from Role where name = :name").setParameter("name", roleName).uniqueResult();
			ss.getTransaction().commit();
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public void save(Role r) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(r);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		
	}


}
