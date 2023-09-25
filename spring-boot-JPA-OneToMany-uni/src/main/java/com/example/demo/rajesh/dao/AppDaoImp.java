package com.example.demo.rajesh.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.rajesh.entity.Course;
import com.example.demo.rajesh.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImp implements AppDao {
	
	//define field for entity Manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public AppDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
		
	}

	@Override
	public Instructor findInstructorById(int id) {
		
		return entityManager.find(Instructor.class, id);
		
	
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		
		Instructor instructor = entityManager.find(Instructor.class, id);
		
		//get the courses
		
		List<Course> courses = instructor.getCourses();
		
		//break association of all courses for this instructor
		/*
		 * If you don't remove instructor from courses... 
		 * it will throw constraint violation exception
		 */
		for(Course course : courses) {
			course.setInstructor(null);
		}
		
		
		entityManager.remove(instructor);
		
	}

	@Override
	public List<Course> findCoursesByInstructorId(int id) {
		
		//create query
		TypedQuery<Course> query = 
				entityManager.createQuery("from Course where instructor.id = :data",Course.class);
		query.setParameter("data", id);
		
		//execute query
		List<Course> courses = query.getResultList();
		
		
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int id) {
		
		/*
		 * The JOIN FETCH is similar to EAGER loading
		 * For more about join fetch scroll down in the last.
		 * 
		 * Note:-
		 * While using the child table in the JOIN FETCH, if the 
		 * child table is in the "Many" relationship then while using the
		 * child table we should use the plurar form of the table appended as "s" in the last.
		 * i.e:-
		 * Here Course and InstructorDetail table is the child table of the Instructor table
		 * and Course is in the OneToMany relation and course is in the "Many" relationship that's why
		 * I am using the course as "courses". 
		 * And InstructorDetail is in the OneToOne relation that's why I am using 
		 * "instructor_detail" not in the plural form.
		 */
		
		TypedQuery<Instructor> query = entityManager.createQuery
				("select i from Instructor i "
						+ "JOIN FETCH i.courses "
						+ "JOIN FETCH i.instructorDetail "
						+ "where i.id = :data ", Instructor.class);
		
		query.setParameter("data", id);
		
		Instructor instructor = query.getSingleResult();
		
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		entityManager.merge(instructor);
		
	}

	@Override
	@Transactional
	public void update(Course course) {
		entityManager.merge(course);
		
	}

	@Override
	public Course findCourseById(int id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}

	@Override
	@Transactional
	public void deleteCourseById(int id) {
		
		//retrive the course
		Course course = entityManager.find(Course.class, id);
		
		entityManager.remove(course);
		
	}

	@Override
	@Transactional
	public void save(Course course) {
		
		entityManager.persist(course);
		
	}

	@Override
	public Course findCourseAndReviewByCourseId(int id) {
		
		//create query
		TypedQuery<Course> query = entityManager.createQuery(
				"select c from Course c "
				+ "JOIN FETCH c.reviews "
				+ "where c.id = :data"
				, Course.class);
		
		query.setParameter("data", id);
		
		
		//execute the query
		Course course = query.getSingleResult();
		
		return course;
		
		
		/*
		 * This fetch query will get converted into this:-
		 *  select 
		 * c1_0.id,
		 * c1_0.instructor_id, 
		 * r1_0.course_id,
		 * r1_0.id,
		 * r1_0.comment,
		 * c1_0.title
		 *   from
		 *      course c1_0
		 *   join
		 *      review r1_0
		 *   on c1_0.id=r1_0.course_id
		 *   where c1_0.id=?
		 */
	}

	
	
	

}

/*
 * A “fetch” join / 'JOIN FETCH' allows associations or collections of values to be initialized along with 
 * their parent objects using a single select. This is particularly useful in the case of a collection.”
 * https://medium.com/javarevisited/spring-jpa-when-to-use-join-fetch-a6cec898c4c6
 */



















