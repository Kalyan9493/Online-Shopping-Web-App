package com.omni.project.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.omni.project.entity.Cart;
import com.omni.project.entity.Product;
import com.omni.project.entity.Transaction;
import com.omni.project.entity.User;
import com.omni.project.repository.CartRepository;
import com.omni.project.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	CartRepository cartRepository;
//	@Override
/*	public String addToCart(HttpServletRequest req) {
		
		
		HttpSession session=req.getSession();
		Cart cart=new Cart("Purchased",(User) session.getAttribute("user"),(Product) session.getAttribute("product"),(Transaction) session.getAttribute("transaction"));
		System.out.println(cart);
		cartRepository.save(cart);
		System.out.println("Product Added to Cart");
		return "Added Succesfully";
	}*/
	
	

}
