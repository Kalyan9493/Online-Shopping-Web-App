package com.omni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omni.project.entity.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
