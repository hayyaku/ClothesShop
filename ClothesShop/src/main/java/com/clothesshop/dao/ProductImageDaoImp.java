package com.clothesshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.Product;
import com.clothesshop.entities.ProductImage;

@Repository
public class ProductImageDaoImp implements ProductImageDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public void save(ProductImage productImage) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(productImage);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductImage> findProductImageByProductId(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			List<ProductImage> productImages = ss.createQuery("FROM ProductImage p where p.productId.id = :id ").setParameter("id", id).list();
			ss.getTransaction().commit();
			return productImages;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}
	@Override
	public boolean deleteImageById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.delete(findProductImageById(id));
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
	public ProductImage findProductImageById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ProductImage productImage = (ProductImage) ss.createQuery("FROM ProductImage p where p.id = :id ").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return productImage;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return null;
	}
	@Override
	public boolean update(ProductImage productImage) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.merge(productImage);
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
