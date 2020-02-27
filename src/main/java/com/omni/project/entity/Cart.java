package com.omni.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="cart")
public class Cart {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "cartid")
		private Long cartid;
		@Column(name="setstatus")
	    private String setStatus;
	    @OneToOne
	    @JoinColumn(name = "userid")
	    private User user;
	    @OneToOne
	    @JoinColumn(name="productid")
	    private Product product;
	    @OneToOne
	    @JoinColumn(name="tid")
	    private Transaction transaction;
	    
	    @Temporal(TemporalType.DATE)
	    private  Date date;
	    
	    public Cart() {
			
		}
	    
	    
	    

		public Cart(String setStatus, User user, Product product, Transaction transaction,Date date) {
			super();
			this.setStatus = setStatus;
			this.user = user;
			this.product = product;
			this.transaction = transaction;
			this.date=date;
		}

		



		public Date getDate() {
			return date;
		}




		public void setDate(Date date) {
			this.date = date;
		}




		public Long getCartid() {
			return cartid;
		}


		public void setCartid(Long cartid) {
			this.cartid = cartid;
		}

		public String getSetStatus() {
			return setStatus;
		}


		public void setSetStatus(String setStatus) {
			this.setStatus = setStatus;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Product getProduct() {
			return product;
		}


		public void setProduct(Product product) {
			this.product = product;
		}


		public Transaction getTransaction() {
			return transaction;
		}


		public void setTransaction(Transaction transaction) {
			this.transaction = transaction;
		}
		
}
