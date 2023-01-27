package com.clothesshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Product;

@Repository
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Product getById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			Product product = (Product) ss.createQuery("from Product where id = :id").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getRandom12Item() {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			List<Product> products = ss.createQuery("FROM Product ORDER BY rand()").setMaxResults(12).list();
			ss.getTransaction().commit();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByCategoryId(List<Long> ids, Integer beginProduct) {
		Session ss =sf.openSession();
		try {
			ss.beginTransaction();
			StringBuilder query = new StringBuilder("from Product p where");
			for(int i=0;i<ids.size();i++) {
				if(i==0) {
					query.append(" p.categoryId.id = "+ids.get(i));
				}else {
					query.append(" or p.categoryId.id = "+ids.get(i));
				}
			}
			List<Product> products = ss.createQuery(query.toString()).setFirstResult(beginProduct).setMaxResults(9).list();
			return products;
		} catch (Exception e) {
			ss.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		
		return null;
	}

	@Override
	public int countProductByCategoryId(List<Long> ids) {
		Session ss =sf.openSession();
		try {
			ss.beginTransaction();
			StringBuilder query = new StringBuilder("select count(*) from Product p where");
			for(int i=0;i<ids.size();i++) {
				if(i==0) {
					query.append(" p.categoryId.id = "+ids.get(i));
				}else {
					query.append(" or p.categoryId.id = "+ids.get(i));
				}
			}
			Object count = ss.createQuery(query.toString()).getSingleResult();
			return ((Number) count).intValue();
		} catch (Exception e) {
			ss.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		
		return 0;
	}

	@Override
	public void save(Product product) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(product);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		
	}

	@Override
	public boolean update(Product product) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.merge(product);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return false;
	}

	@Override
	public boolean deleteById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.delete(getById(id));
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return false;
	}

}
