package com.example.demo.rajesh.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	// annotate the class as an entity and map to db table

	// define the fields

	// annotate the field with db column name

	// generate getter/setter

	// generate toString() methods
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	//one to one mapping for field instructor_detail_id 
		//to table instructor_detail tables
		/*
		 * Let's understand about @JoinColumn
		 * It tell hibernate that join the 'instructor_detail_id' present
		 * into the current table(Instructor) which is a foreign key of the Instructor_detail table,
		 * to join with instructor_detail table,
		 * 
		 * Also inside the @JoinColumn we always write the foreign key of a table 
		 * which is pointed to other table.
		 * i.e:- Inside the Instructor table coulumn "instructor_detail_id"
		 * is a foreign key which is pointed to the InstructorDetail table
		 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	
	/*
	 * For OneToMany mapping, the fetchtype is by-default 'LAZY'
	 * so, Only for readbility I added here 'LAZY'
	 */
	/*
	 * For Unserstanding difference between @JoinColumn and mappedBy scroll
	 * down in this editor
	 */
	@OneToMany(mappedBy = "instructor",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}



	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	


	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	//add method for bi-directional releationship
	
	public void add(Course newCourse) {
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		
		courses.add(newCourse);
		newCourse.setInstructor(this);
		
	}

	public Instructor() {
		// TODO Auto-generated constructor stub
	}



	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	

}



/*
 * @JoinColumn Annotation:-
 * In a One-to-Many/Many-to-One relationship, the owning side is usually defined on the "many" side
 *  of the relationship. It’s usually the side that owns the foreign key.
 *  The @JoinColumn annotation defines that actual physical mapping on the owning side:
 *  
 *  
 *  mappedBy Attribute:-
 *  Once we have defined the owning side of the relationship, Hibernate already has
 *   all the information it needs to map that relationship in our database.
 *   
 *   To make this association bidirectional, all we’ll have to do is to define the 
 *   referencing side. The inverse or the referencing side simply maps to the owning side.
 *   
 *   To make this association bidirectional, all we’ll have to do is to define the referencing side. 
 *   The inverse or the referencing side simply maps to the owning side.
 *   
 *   i.e:-
 *   let's understand:-
 *   When we check for the Course table creation, the course table has foreign key
 *   that is why when we open the Course Entity class while giving the relation ManyToOne,
 *   we define the relation with @JoinColumn annotation.
 *   Now for making this relation bi-directional, while creating the Course entity in Instructor class
 *   we use the "mappedBy" parameter. it works as a refernce of mapping because physical mapping already done
 *   by @JoinColumn annotation
 *   
 *   https://www.baeldung.com/jpa-joincolumn-vs-mappedby#:~:text=The%20%40JoinColumn%20annotation%20helps%20us,owning%20side)%20of%20the%20relationship.
 */




































