package com.ayan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ayan.hibernate.entity.Course;
import com.ayan.hibernate.entity.Instructor;
import com.ayan.hibernate.entity.InstructorDetail;
import com.ayan.hibernate.entity.Review;

public class Starter {

	public static void main(String[] args) {

		int id = 11; // you will get this id from course table of database.

		// createCourseAndReviews();
		getCourseAndReviews(id);
		// deleteCourseAndReviews(id);
	}

	private static void deleteCourseAndReviews(int id) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Course tempCourse = session.get(Course.class, id);

			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());

			session.delete(tempCourse);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

			factory.close();
		}
	}

	private static void getCourseAndReviews(int id) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Course tempCourse = session.get(Course.class, id);

			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

			factory.close();
		}
	}

	private static void createCourseAndReviews() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Course tempCourse = new Course("Advance java master class");

			tempCourse.addReview(new Review("good concepts"));
			tempCourse.addReview(new Review("well structered"));
			tempCourse.addReview(new Review("bad shitty course"));

			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());

			session.save(tempCourse);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

			factory.close();
		}
	}

}
