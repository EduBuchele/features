package com.sb.features.webclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class WebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}

	@Bean
	RestClient crudClien() {
		return RestClient.create("https://crudcrud.com/api/228f4f7b8a3d45b282cfe4269906a734");
	}

	@Bean
	ApplicationRunner runner(PersonService personService) {
		return args -> {
			var person1 = new Person("Test01", 16);
			var person2 = new Person("Test02", 21);
//			personService.createPerson(person1);
//			personService.createPerson(person2);
			String personId01 = "65d65aff6227a803e824e12a";
			System.out.println(personService.getPerson(personId01));
			person1 = person1.withAge(45);
			personService.updatePerson(personId01, person1);
			System.out.println(personService.getPerson(personId01));
			personService.deletePerson(personId01);
			System.out.println(personService.listPerson());

		};

	}

}
