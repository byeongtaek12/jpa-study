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

			Customer customer = new Customer("ID0005", "Jin"); // 비영속 상태(new)
			em.persist(customer); // Customer 객체 영속 상태(Managed)

			em.detach(customer); // Customer 객체 준영속 상태(Detached)

			Customer foundCustomer = em.find(Customer.class, "ID0005");
			System.out.println(foundCustomer);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
