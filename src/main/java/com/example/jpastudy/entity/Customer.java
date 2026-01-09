package com.example.jpastudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_tb")
public class Customer {

	@Id
	private String id;
	private String name;
	private long registerDate;

	protected  Customer () {

	}

	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
		this.registerDate = System.currentTimeMillis();
	}

	public static Customer sample() {
		return new Customer("ID0001", "Kim");
	}
}
