package com.omni.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.omni.project.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	

}
