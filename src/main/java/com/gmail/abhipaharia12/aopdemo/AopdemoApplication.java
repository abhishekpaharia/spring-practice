package com.gmail.abhipaharia12.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gmail.abhipaharia12.aopdemo.dao.AccountDAO;
import com.gmail.abhipaharia12.aopdemo.dao.MemebershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemebershipDAO theMembershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemebershipDAO theMembershipDAO) {

		// call the business method
		theAccountDAO.addAccount();

		theMembershipDAO.addAccount();

		// // do it again!
		// System.out.println("\n let's call it again!\n");

		// // call the business method again
		// theAccountDAO.addAccount();

		// call the membership business method

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

	}

}
