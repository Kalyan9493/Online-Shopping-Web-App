package com.omni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omni.project.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

}

