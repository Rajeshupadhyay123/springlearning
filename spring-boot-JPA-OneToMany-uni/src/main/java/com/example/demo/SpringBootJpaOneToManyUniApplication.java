package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.rajesh.dao.AppDao;
import com.example.demo.rajesh.entity.Course;
import com.example.demo.rajesh.entity.Instructor;
import com.example.demo.rajesh.entity.InstructorDetail;
import com.example.demo.rajesh.entity.Review;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringBootJpaOneToManyUniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToManyUniApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {

		return runner -> {
			//createCourseAndReview(appDao);
			
			//retriveCourseAndReviews(appDao);
			
			deleteCourseAndReview(appDao);
			
		};
	}

	private void deleteCourseAndReview(AppDao appDao) {
		
		int id =10;
		
		System.out.println("Deleting the course id: "+id);
		
		appDao.deleteCourseById(id);
		
		System.out.println("Done!");
		
		/*
		 * Let me explain how this delete operation work:-
		 * 1.It fetch the Instructor and Course with left join, 
		 * in this case it is null;
		 * 
		 * 2.Fetch the Review table with help of course_id, in this case we found something.
		 * so, it one by one update the course_id = null where course_id is match.
		 * 
		 * 3.After updating the course_id as NULL into the Review table then delete this Review in the table.
		 * Because if we didn't set the course_id as NULL then it can throw the forgein key constrain exception
		 * 
		 * 4.We remove every dependent table, Now delete the Course from the Course table
		 */
		
		
		
	}

	private void retriveCourseAndReviews(AppDao appDao) {
		//get the course and review
		int id=10;
		Course course = appDao.findCourseAndReviewByCourseId(id);
		
		//print the course
		System.out.println(course);
		
		//print the review
		System.out.println(course.getReviews());
	}

	private void createCourseAndReview(AppDao appDao) {
		
		//create a course
		Course course = new Course("Pacman - How to score");
		
		//add some review
		course.addReview(new Review("Great Course .............love it"));
		course.addReview(new Review("Cool Course .............job done"));
		course.addReview(new Review("What a dumb course, you are bad"));
		
		//save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());
		
		appDao.save(course);
		
		/*
		 * Lets explain the flow of this save method
		 * 
		 * 1.First It insert the data into the Course Table due to first call on this table
		 * 2.It insert the review into the Review Table due to @OneToMany relationship and CascadeType.ALL
		 * But here it doesn't set the course id for Review table
		 * 3.It update Review Table and update the Review Table and set the course_id due to @JoinColumn annotation
		 */
		
		
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
