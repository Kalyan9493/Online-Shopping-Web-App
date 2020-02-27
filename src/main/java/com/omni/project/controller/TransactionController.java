package com.omni.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.omni.project.entity.Cart;
import com.omni.project.entity.Product;
import com.omni.project.entity.Transaction;
import com.omni.project.entity.User;
import com.omni.project.repository.CartRepository;
import com.omni.project.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService tservice;
	
	@Autowired
	CartRepository cartRepository;
	
	@PostMapping("/savetransaction")
	public ModelAndView saveTransaction(@RequestParam("cardnumber") Long cardnumber,
								@RequestParam("cvv") Integer cvv,
								@RequestParam("expmonth") String expirydate,
								@RequestParam("name") String name,HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		Product p= (Product) session.getAttribute("product");
		Double amount=p.getPrice();
		System.out.println(amount);
		Transaction transaction= new Transaction(cardnumber, cvv, expirydate, name);
		transaction.setAmount(amount);
		tservice.saveDetails(transaction);
		System.out.println("Transaction Saved");
		Transaction t=tservice.getId(cardnumber);
		session.setAttribute("transaction", t);
		
		User user=(User) session.getAttribute("user");
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		
		Cart cart= new Cart("Purchased", user, p, t,sqlDate);
		System.out.println(sqlDate);
		cartRepository.save(cart);
		System.out.println("Added to Cart");
		mv.setViewName("continue");
		return mv;
	}
	@GetMapping("/gettransaction")
	public List<Transaction> getTransaction() {
		return tservice.getDetails();
	}
	
	@PostMapping("/transaction/{id}")
	public Transaction transaction(@PathVariable("id") Long id) {
		return tservice.gettranssaction(id);
	}
	
	@GetMapping("/mycart")
	public ModelAndView mycart(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		Product product= (Product) session.getAttribute("product");
		Transaction transaction=(Transaction) session.getAttribute("transaction");
		if(user!=null && product!=null && transaction!=null) {
		
		mv.addObject("userid", user.getUserid());
		mv.addObject("name", user.getFirstname());
		mv.addObject("product", product.getName());
		mv.addObject("cost", product.getPrice());
		mv.addObject("tid", transaction.getTid());
		mv.setViewName("mycart");
		}
		else {
			String msg="Cart is Empty";
			mv.addObject("msg", msg);
			mv.setViewName("cart");
		}
		return mv;
	}

}
