package com.omni.project.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.project.entity.User;
import com.omni.project.repository.UserRepository;
import com.omni.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	public void register(User user) {
		
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);;
		
	}

	@Override
	public List<User> listUsers() {
		List<User> users=userRepository.findAll();
		return users;
	}

	@Override
	public void updateUser(User user, Long id) {
	
		User user1=new User();
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
	//	Query query=session.createQuery("update user u set u.firstname='"+user.getFirstname()+"' u.lastname='"+user.getLastname()+"' u.emailid = '"+user.getEmailid()+"' u.mobileno='"+user.getMobileno()+"' u.address='"+user.getAddress()+"' u.username='"+user.getUsername()+"' u.password='"+user.getPassword()+"' where u.userid='"+user.getUserid()+"'");
	//	query.executeUpdate();
	
		user1=session.get(User.class, id);
		System.out.println(user1);
		user1.setAddress(user.getAddress());
		user1.setEmailid(user.getEmailid());
		user1.setFirstname(user.getFirstname());
		user1.setLastname(user.getLastname());
		user1.setMobileno(user.getMobileno());
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		session.getTransaction().commit();
		System.out.println("User Updated");
		
	}

	@Override
	public User getUser(Long id) {
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		User user= session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}

	

}
