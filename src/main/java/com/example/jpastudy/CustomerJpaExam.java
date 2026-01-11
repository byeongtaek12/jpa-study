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

			Major major = new Major("Computer Science", "College of Engineering");
			em.persist(major);

			Student student = new Student("Kim", "3");
			student.setMajorId(major.getMajorId());
			em.persist(student);

			em.flush();
			em.clear();

			Student foundStudent = em.find(Student.class, 1);
			System.out.println(foundStudent);

			Major foundMajor = em.find(Major.class, foundStudent.getMajorId());
			System.out.println(foundMajor);



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
