package com.example.demo.rajesh.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.rajesh.entity.Course;
import com.example.demo.rajesh.entity.Instructor;
import com.example.demo.rajesh.entity.Student;

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

	@Override
	public Course findCourseAndStudentByCourseId(int id) {
		
		//create query
		TypedQuery<Course> query = entityManager.createQuery(
				"select c from Course c "
				+ "JOIN FETCH c.students "
				+ "where c.id = :data"
				, Course.class);
		
		query.setParameter("data", id);
		
		//execute query
		Course course = query.getSingleResult();
		
		return  course;
		
		
		/*
		 * How this method became after excute:-
		 * select
        c1_0.id,
        c1_0.instructor_id,
        s1_0.course_id,
        s1_1.id,
        s1_1.email,
        s1_1.first_name,
        s1_1.last_name,
        c1_0.title 
    from
        course c1_0 
    join
        (course_student s1_0 
    join
        student s1_1 
            on s1_1.id=s1_0.student_id) 
                on c1_0.id=s1_0.course_id 
        where
            c1_0.id=?
		 */
	}

	@Override
	public Student findStudentAndCoursesByStudentId(int id) {
		
		//create query
				TypedQuery<Student> query = entityManager.createQuery(
						"select s from Student s "
						+ "JOIN FETCH s.courses "
						+ "where s.id = :data"
						, Student.class);
				
				query.setParameter("data", id);
				
		//execute the query	
		Student student = query.getSingleResult();		
		
		return student;
		
		
		/*
		 * select
        s1_0.id,
        c1_0.student_id,
        c1_1.id,
        c1_1.instructor_id,
        c1_1.title,
        s1_0.email,
        s1_0.first_name,
        s1_0.last_name 
    from
        student s1_0 
    join
        (course_student c1_0 
    join
        course c1_1 
            on c1_1.id=c1_0.course_id) 
                on s1_0.id=c1_0.student_id 
        where
            s1_0.id=?
		 */
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		
		//Retrieve the student
		Student student = entityManager.find(Student.class, id);
		
		//delete the student
		entityManager.remove(student);
		
	}

	
	
	

}

/*
 * A “fetch” join / 'JOIN FETCH' allows associations or collections of values to be initialized along with 
 * their parent objects using a single select. This is particularly useful in the case of a collection.”
 * https://medium.com/javarevisited/spring-jpa-when-to-use-join-fetch-a6cec898c4c6
 */



















