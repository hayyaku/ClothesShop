package com.clothesshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clothesshop.entities.ProductDetail;

@Repository
public class ProductDetailDaoImp implements ProductDetailDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean save(ProductDetail productDetail) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.save(productDetail);
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
	public ProductDetail findProductDetailById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ProductDetail productDetail = (ProductDetail) ss.createQuery("from ProductDetail where id = :id").setParameter("id", id).uniqueResult();
			ss.getTransaction().commit();
			return productDetail;
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
			return null;
	}

	@Override
	public boolean updateProductDetail(ProductDetail productDetail) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.merge(productDetail);
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
	public boolean deleteProductDetailById(Long id) {
		Session ss = sf.openSession();
		try {
			ss.beginTransaction();
			ss.delete(findProductDetailById(id));
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
