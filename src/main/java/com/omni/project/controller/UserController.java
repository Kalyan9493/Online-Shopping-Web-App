package com.omni.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.omni.project.entity.User;
import com.omni.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ModelAndView register(@RequestParam("firstname") String fname,
			@RequestParam("lastname") String lname,
			@RequestParam("emailid") String email,
			@RequestParam("mobileno") long mobile,
			@RequestParam("address") String address,
			@RequestParam("username") String uname,
			@RequestParam("password") String pass,HttpServletRequest req) {
		
		User user= new User(fname, lname, email, mobile,address, uname, pass);
		
		
		ModelAndView mv=new ModelAndView();
		
		userService.register(user);
		mv.setViewName("index");
		String msg="User Registered succesfully";
		mv.addObject("msg", msg);
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String uname,@RequestParam("password") String pass, HttpServletRequest req) {
		
		HttpSession httpSession = req.getSession();
	
		ModelAndView mv=new ModelAndView();
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		User user= (User) session.createQuery("from user U where U.username = '"+uname+"' and password = '"+pass+"'").uniqueResult();
		session.getTransaction().commit();
		if(user!=null) {
			mv.addObject("uname",uname);
			mv.addObject("name", user.getFirstname());
			mv.setViewName("home");
			httpSession.setAttribute("user", user);
			return mv;
			
		}
		else {
		String errmsg="Enter Correct Username And Password";
		mv.addObject("errmsg",errmsg);
		mv.setViewName("index");
		return mv;
		}
	}

	@PostMapping("/deleteuser")
	public String deleteuser(HttpServletRequest req) {
		HttpSession session=req.getSession();
		Long id=(Long) session.getAttribute("id");
		userService.deleteUser(id);
		return "Deleted";
		
	}
	
	@PostMapping("/update")
	public ModelAndView update(@RequestParam("firstname") String fname,
			@RequestParam("lastname") String lname,
			@RequestParam("emailid") String email,
			@RequestParam("mobileno") long mobile,
			@RequestParam("address") String address,
			@RequestParam("username") String uname,
			@RequestParam("password") String pass,HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		User user=new User(fname, lname, email, mobile, address, uname,pass);
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		Long id=u.getUserid();
		user.setUserid(id);
		userService.updateUser(user,id);
		
		System.out.println("User Updated");
		mv.setViewName("home");
		mv.addObject("name",user.getFirstname());
		return mv;
	}
	
	@GetMapping("/userslist")
	public List<User> usersList(){
		List<User> users= userService.listUsers();
		return users;
	}
	
	@GetMapping("/viewprofile")
	public ModelAndView viewProfile(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		Long id=u.getUserid();
		User user=userService.getUser(id);
		mv.setViewName("viewprofile");
		mv.addObject("fname", user.getFirstname());
		mv.addObject("lname", user.getLastname());
		mv.addObject("email", user.getEmailid());
		mv.addObject("mobile", user.getMobileno());
		mv.addObject("address", user.getAddress());
		mv.addObject("uname", user.getUsername());
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		session.invalidate();
		return mv;
		
	}
}
