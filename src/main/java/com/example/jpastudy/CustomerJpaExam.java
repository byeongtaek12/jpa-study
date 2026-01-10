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

		try {

			Customer customer = new Customer();
			customer.setName("Oh");
			customer.setRegisterDate(System.currentTimeMillis());
			em.persist(customer);

			System.out.println("==================Before Commit================");

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
