package com.omni.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omni.project.entity.Transaction;

@Service
public interface TransactionService {

	 public List<Transaction> getDetails();
	 public void saveDetails(Transaction transaction);
	public Transaction gettranssaction(Long id);
	public Transaction getId(Long number);
	 
}
