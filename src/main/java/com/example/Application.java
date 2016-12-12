package com.example;

import com.example.gen.AddPersonResponse;
import com.example.gen.DeletePersonResponse;
import com.example.gen.GetAllPersonResponse;
import com.example.gen.GetPersonResponse;
import com.example.model.Person;
import com.example.service.PersonServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			
	}

	@Bean
	CommandLineRunner lookup(PersonServiceClient personServiceClient) {
		return args -> {
			Person p1 = new Person(); p1.setName("Akila"); p1.setId(1); p1.setAge(27);
			Person p2 = new Person(); p2.setName("Amila"); p2.setId(2); p2.setAge(20);

			AddPersonResponse addResponse = personServiceClient.addPerson(p1);
			logger.info("Person {} is added : {}", p1.toString(), addResponse.isStatus());

			addResponse = personServiceClient.addPerson(p2);
			logger.info("Person {} is added : {}", p2.toString(), addResponse.isStatus());

			GetPersonResponse getResponse = personServiceClient.getPerson(1);
			logger.info("Person 1 is loaded : {}", getResponse.getPerson().getName());

			GetAllPersonResponse getAllResponse = personServiceClient.getAllPerson();
			logger.info("Getting all");
			printAllNames(getAllResponse);

			DeletePersonResponse deleteResponse = personServiceClient.deletePerson(2);
			logger.info("Person {} is deleted : {}", p2.toString(), addResponse.isStatus());

			logger.info("Getting all again");

			getAllResponse = personServiceClient.getAllPerson();
			printAllNames(getAllResponse);
		};
	}

	private static void printAllNames(GetAllPersonResponse getAllPersonResponse) {
		for (com.example.gen.Person p: getAllPersonResponse.getPersonList()) {
			logger.info("{} is loaded", p.getName());
		}
	}
}