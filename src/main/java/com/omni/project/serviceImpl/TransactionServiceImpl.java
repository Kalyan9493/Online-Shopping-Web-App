package com.omni.project.serviceImpl;


import com.omni.project.service.TransactionService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.project.entity.Transaction;
import com.omni.project.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getDetails() {
	List<Transaction> t=transactionRepository.findAll();
		return t;
	}

	@Override
	public void saveDetails(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public Transaction gettranssaction(Long id) {
		transactionRepository.getOne(id);
		return null;
	}

	public Transaction getId(Long number) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Transaction.class).buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Transaction t = (Transaction) session.createQuery("from transaction t where t.cardnumber = '"+number+"'").uniqueResult();
		session.getTransaction().commit();
		return t;
	}
}
