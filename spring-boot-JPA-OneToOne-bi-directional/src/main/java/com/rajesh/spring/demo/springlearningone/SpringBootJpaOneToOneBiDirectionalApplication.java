package com.rajesh.spring.demo.springlearningone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rajesh.spring.demo.springlearningone.dao.AppDao;
import com.rajesh.spring.demo.springlearningone.entity.Instructor;
import com.rajesh.spring.demo.springlearningone.entity.InstructorDetail;

@SpringBootApplication
public class SpringBootJpaOneToOneBiDirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToOneBiDirectionalApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		
		return runner-> {
			//createInstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetail(appDao);
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id=1;
		System.out.println("Deleting the instruction detail id: "+id);
		appDao.deleteInstructorDetailById(id);
		System.out.println("Done");
		
	}



	private void findInstructorDetail(AppDao appDao) {
		//get the instructor detail object
		
		int id=2;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		
		//print the instructor detail
		System.out.println("tempInstructorDetail: "+instructorDetail);
		
		//print the associated instructor
		System.out.println("the associated instructor: "+ instructorDetail.getInstructor());
	}



	private void deleteInstructor(AppDao appDao) {
		int id=1;
		System.out.println("Deleting instructor id: "+id);
		appDao.deleteInstructorById(id);
		
		
		
	}

	private void findInstructor(AppDao appDao) {
		
		int id =2;
		System.out.println("Finding Instructor id: "+id);
		
		Instructor instructor = appDao.findInstructorById(id);
		
		System.out.println("tempInstructor: "+instructor);
		System.out.println("the associated instructorDetails: "+instructor.getInstructorDetail());
		
	}

	private void createInstructor(AppDao appDao) {
		
//		Instructor instructor =
//				new Instructor("Rajesh","upadhyay","raj@123.com");
//		
//		InstructorDetail instructorDetail = 
//				new InstructorDetail("https://tcsglobal.udemy.com/","Coding");
		
		
		
		Instructor instructor =
				new Instructor("shalu","upadhyay","shalu@123.com");
		
		InstructorDetail instructorDetail = 
				new InstructorDetail("https://tcsglobal2.udemy.com/","Singing");
		
		
		//associate the object
		instructor.setInstructorDetail(instructorDetail);
		
		//save the instructor
		/*
		 * Note:This also save the details into details table because of
		 * CascadeType.ALL
		 */
		System.out.println("Saving the instructor: "+instructor);
		appDao.save(instructor);
		
	}

}
