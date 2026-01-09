package com.example.jpastudy;

import java.util.List;

import com.example.jpastudy.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomerJpaExam {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =em.getTransaction();

		tx.begin();

		try {

			Customer customer = new Customer("ID0004", "Lee"); // 비영속 상태(new)
			em.persist(customer); // Customer 객체 영속 상태(Managed)

			Query query = em.createQuery("SELECT c FROM Customer c", Customer.class);
			List<Customer> customers = query.getResultList();
			System.out.println(customers);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
