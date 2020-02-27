package com.omni.project.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.omni.project.entity.Product;
import com.omni.project.repository.ProductRepository;
import com.omni.project.service.ProductService;

public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public Product getProduct(String productname) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Product product= (Product) session.createQuery("from product P where P.name = '"+productname+"'").uniqueResult();
		session.getTransaction().commit();
		
		return product;
	}

 
	}
