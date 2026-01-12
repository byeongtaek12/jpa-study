package com.example.jpastudy;

import com.example.jpastudy.entity.Major;
import com.example.jpastudy.entity.Student;

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

			Student student = new Student("Oh","3");
			em.persist(student);

			Major major = new Major("Computer Science", "College of Engineering");
			major.getStudents().add(student);
			em.persist(major);

			tx.commit();
		} catch (Exception e) {
			e.getStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
