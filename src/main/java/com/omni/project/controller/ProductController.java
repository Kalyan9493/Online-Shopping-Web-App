package com.omni.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.omni.project.entity.Product;
import com.omni.project.repository.ProductRepository;
import com.omni.project.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProductService productService;
	Product product;
	
	@PostMapping("/product/{selectedProduct}")
	public ModelAndView selectedProduct(@PathVariable("selectedProduct") String selectedProduct, HttpServletRequest req) {

		ModelAndView mv=new  ModelAndView();
		HttpSession session = req.getSession();
		switch (selectedProduct) {
		case "Asus Gen":
			product = productService.getProduct("Asus Gen");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;

		case "Hp":
			product = productService.getProduct("Hp");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;

		case "Asus":
			product = productService.getProduct("Asus");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;
		case "Redmi":
			product = productService.getProduct("Redmi");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;
		case "Samsung M30":
			product = productService.getProduct("Samsung M30");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;
		case "Cool Pad Note 3":
			product = productService.getProduct("Cool Pad Note 3");
			session.setAttribute("product", product);
			System.out.println(product.getPrice());
			mv.setViewName("transaction");
			return mv;

		default:
			System.out.println("Item Not Found");
		}
		return new ModelAndView();
	}

	@RequestMapping("/listproducts")
	public List<Product> productlist() {

		List<Product> products = productRepo.findAll();
		return products;
	}

	@PostMapping("/addproduct")
	public void saveProducts(@RequestParam("name") String name, @RequestParam("catagory") String catagory,
			@RequestParam("price") Double price) {

		Product product = new Product(name, catagory, price);
		productService.saveProduct(product);
	}
}
