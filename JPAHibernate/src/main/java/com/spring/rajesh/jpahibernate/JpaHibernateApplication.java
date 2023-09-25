package com.spring.rajesh.jpahibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.rajesh.jpahibernate.dao.StudentDao;
import com.spring.rajesh.jpahibernate.entity.Student;
import com.spring.rajesh.jpahibernate.log.IAppLogger;
import com.spring.rajesh.jpahibernate.log.LogFactory;

@SpringBootApplication
public class JpaHibernateApplication {
	
	IAppLogger logger = LogFactory.getLoggerInstance(JpaHibernateApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner->{
			//createStudent(studentDao);
			
			//readStudent(studentDao);
			
			//getStudentByLastName(studentDao);
			
			//getAllStudent(studentDao);
			
			updateStudentLastNameById(studentDao);
			
			//updateStudent(studentDao);
			
			//deleteStudent(studentDao);
			
			//deleteAll(studentDao);
		};
	}

	private void updateStudentLastNameById(StudentDao studentDao) {
		String lastName="Upadhyay";
		int id=4;
		int count=0;
		
		logger.log("Checking is, id exist!----------");
		Student student = studentDao.findbyId(id);
		
		if(student!=null) {
			logger.log("Checking is, id existed...............");
			count = studentDao.updatLastNameById(lastName, id);
		}
		
		if(count>0) {
			logger.log("Table updated successful");
		}
		
	}

	private void deleteAll(StudentDao studentDao) {
		
		logger.log("deleting all student.............");
		int numDeleted= studentDao.deleteAll();
		logger.log("Deleted row count: "+numDeleted);
		
	}

	private void deleteStudent(StudentDao studentDao) {
		
		int id=3;
		logger.log("Deleting student id: "+id);
		studentDao.delete(id);
		
	}

	private void updateStudent(StudentDao studentDao) {
		
		//retrive student based on id: primary
		int id=1;
		logger.log("Getting student with id:  "+id);
		Student student= studentDao.findbyId(id);
		
		//change first name
		logger.log("Updating student...............");
		student.setFirstName("Rajesh");
		
		//update the student
		studentDao.update(student);
		
		//display student
		logger.log("Updated student:       "+student);
	}

	private void getAllStudent(StudentDao studentDao) {
		
		logger.log("Getting ALl student record");
		List<Student> studenList = null;
		studenList = studentDao.findAll();
		if(studenList!=null) {
			for(Student student: studenList) {
				logger.log(student.toString());
			}
		}
		
	}

	private void getStudentByLastName(StudentDao studentDao) {
		
		logger.log("Getting student by last name................");
		Student student= studentDao.findByLastName("upadhyay");
		logger.log(student.toString());
		
		
	}

	private void readStudent(StudentDao studentDao) {
		
		//create a student object
		logger.log("Creating the student.................");
		Student tempStudent = new Student("Ram","Singh","dnskd@gm.com");
		
		//save the student
		logger.log("Saving the student.............");
		studentDao.save(tempStudent);
		
		//display id of the saved student
		logger.log("saved student id: "+tempStudent.getId());
		
		//retrieve the student based on id
		logger.log("Getting saved student: " );
		Student saveStudent = studentDao.findbyId(tempStudent.getId());
		
		//display student
		logger.log(saveStudent.toString());
	}

	private void createStudent(StudentDao studentDao) {
		
		//create the student object
		logger.log("creating the student");
		Student student = new Student("Rajesh","Upadhyay","pr2@gmail.com");
		
		//save the student object
		logger.log("saving the student...................");
		studentDao.save(student);
		
		//display the id of the save student
		logger.log("saved student id: "+student.getId());
	}

}
