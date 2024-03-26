package com.gmail.abhipaharia12.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gmail.abhipaharia12.cruddemo.dao.AppDao;
import com.gmail.abhipaharia12.cruddemo.entity.Instructor;
import com.gmail.abhipaharia12.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//deleteInstructorDetail(appDAO);
			//findInstructorDetail(appDAO);
			createInstructorDetailWithInstructor(appDAO);
		};
	}
	private void deleteInstructorDetail(AppDao appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDAO) {

		// get the instructor detail object
		int theId = 6;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDao appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDao appDAO) {

		
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");
		
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// No need for this, because there is no column in instructor_detail table whose value depends on tempInstructor.id
		//tempInstructorDetail.setInstructor(tempInstructor);

		System.out.println("before save : " + tempInstructorDetail);
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!"); 
		System.out.println("after save : " + tempInstructorDetail);
		System.out.println("Saved instructor: " + tempInstructor);
	}

	private void createInstructorDetailWithInstructor(AppDao appDAO) {

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");
		
		// create the instructor
		Instructor tempInstructor =
		new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// associate the objects
		tempInstructorDetail.setInstructor(tempInstructor);

		// if you dont add below line, instructor_detail_id will be null
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("before save : " + tempInstructorDetail);
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.saveInstructorDetail(tempInstructorDetail);
		System.out.println("Done!"); 
		System.out.println("after save : " + tempInstructorDetail);
		System.out.println("Saved instructor: " + tempInstructor);
	}
}
