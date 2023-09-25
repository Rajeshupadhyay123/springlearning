package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.dao.AppDao;
import com.example.demo.dao.entity.Course;
import com.example.demo.dao.entity.Instructor;
import com.example.demo.dao.entity.InstructorDetail;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringBootJpaOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {

		return runner -> {
			// createInstructor(appDao);
			// findInstructor(appDao);
			// deleteInstructor(appDao);

			//createInstructorWithCourses(appDao);
			//findInstructorWithCourses(appDao);
			
			//findCoursesForInstructor(appDao);
			
			//findInstructorWithCoursesJoinFetch(appDao);
			
			//updateInstructor(appDao);
			
			//updateCourse(appDao);
			
			//deleteInstructor(appDao);
			
			deleteCourse(appDao);
		};
	}

	private void deleteCourse(AppDao appDao) {
		
		int id=10;
		
		System.out.println("Deleting course id: "+id);
		
		appDao.deleteCourseById(id);
		
	}

	private void updateCourse(AppDao appDao) {
		
		int id=10;
		
		System.out.println("Finding Course id: "+id);
		
		Course course = appDao.findCourseById(id);
		System.out.println("Course is: "+course);
		
		//update course
		course.setTitle("JAVA DEVELOPER ASP..");
		appDao.update(course);
		
		System.out.println(" Updated Course is: "+course);
	}

	private void updateInstructor(AppDao appDao) {
		
		int id=1;
		
		//find the instructor
		System.out.println("Finding Instructor id "+id);
		Instructor instructor = appDao.findInstructorById(id);
		
		//updtae the instructor
		System.out.println("Updated instructor id: "+id);
		instructor.setLastName("TESTER");
		
		appDao.update(instructor);
		
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		
		int id=1;
		
		//find the instructor
		System.out.println("Finding Instructor id: "+id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);
		
		System.out.println("instructor: "+instructor);
		System.out.println("the associated courses: "+instructor.getCourses());
		
	}

	@Transactional
	private void findCoursesForInstructor(AppDao appDao) {
		int id=1;
		System.out.println("Finding instructor id: "+id);
		
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor: "+instructor);
		
		//find courses for instructor
		System.out.println("Finding courses for instructor id: "+id);
		List<Course> courses = appDao.findCoursesByInstructorId(id);
		
		instructor.setCourses(courses);
		
		System.out.println("the associated courses: "+instructor.getCourses());
		
		
		
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id=1;
		System.out.println("Finding instructor id: "+id);
		
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor: "+instructor);
		System.out.println("the associated courses:  "+instructor.getCourses());
		
	}

	private void createInstructorWithCourses(AppDao appDao) {


		//Creating Instructor
		Instructor instructor = new Instructor("shalu", "upadhyay12", "shalu@123.com");

		InstructorDetail instructorDetail
		= new InstructorDetail("https://tcsglobal231.udemy.com/", "Singing");

		//associate the object with InstructorDetail table
		instructor.setInstructorDetail(instructorDetail);
		
		//Creating courses
		Course tempCourse1 = new Course("Air Guitar -- The master");
		Course tempCourse2 = new Course("The Java -- The foundation");
		
		//add courses to instructor
		//Note: This will also save the courses
		//because of CascaseType.PERSIST
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);
		
		//save the instructor
		System.out.println("Saving the instructor: "+instructor);
		System.out.println("The Course: "+instructor.getCourses());
		appDao.save(instructor);
		

	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);
		appDao.deleteInstructorById(id);

	}

	private void findInstructor(AppDao appDao) {

		int id = 2;
		System.out.println("Finding Instructor id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("tempInstructor: " + instructor);
		System.out.println("the associated instructorDetails: " + instructor.getInstructorDetail());

	}

	private void createInstructor(AppDao appDao) {

//		Instructor instructor =
//				new Instructor("Rajesh","upadhyay","raj@123.com");
//		
//		InstructorDetail instructorDetail = 
//				new InstructorDetail("https://tcsglobal.udemy.com/","Coding");

		Instructor instructor = new Instructor("shalu", "upadhyay", "shalu@123.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://tcsglobal2.udemy.com/", "Singing");

		// associate the object
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		/*
		 * Note:This also save the details into details table because of CascadeType.ALL
		 */
		System.out.println("Saving the instructor: " + instructor);
		appDao.save(instructor);

	}

}
