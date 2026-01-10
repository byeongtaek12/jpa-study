package com.example.jpastudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer_tb")
@ToString
@Setter
@Getter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private long registerDate;

	public Customer() {

	}

	public Customer(Long id, String name) {
		this.id = id;
		this.name = name;
		this.registerDate = System.currentTimeMillis();
	}

	public static Customer sample() {
		return new Customer(1L, "Kim");
	}
}
