package com.example.jpastudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer_tb")
@ToString
@Setter
@Getter
@TableGenerator(name="id_generator",
				table="customer_id",
				pkColumnName = "id_name",
				pkColumnValue ="customer_id",
				valueColumnName = "next_value",
				initialValue = 0,
				allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
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
