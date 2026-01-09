package com.example.jpastudy;

import com.example.jpastudy.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =em.getTransaction();

		tx.begin();

		em.persist(Customer.sample());

		tx.commit();
		em.close();
		emf.close();
	}
}
