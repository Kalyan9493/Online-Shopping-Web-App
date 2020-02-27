package com.omni.project.service;

import org.springframework.stereotype.Service;

import com.omni.project.entity.Product;

@Service
public interface ProductService {

	public void saveProduct(Product product);

	public Product getProduct(String string);
}
