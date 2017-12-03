package com.example.springnavigatordemo;

import com.example.springnavigatordemo.model.Person;
import com.example.springnavigatordemo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringnavigatordemoApplication {

	private Logger log = LoggerFactory.getLogger(SpringnavigatordemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringnavigatordemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(PersonRepository repo){
		return args->{
			repo.save(new Person("Jack", "Jackus"));
			repo.save(new Person("Mark", "Markus"));
			repo.save(new Person("Lasi", "Lasius"));
			repo.save(new Person("Hugh", "Lory"));

			for (Person person : repo.findAll()) {
				log.info(person.toString());
			}
		};
	}
}
