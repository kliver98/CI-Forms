package co.edu.icesi.ci.thymeval;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import co.edu.icesi.ci.thymeval.model.User;
import co.edu.icesi.ci.thymeval.model.UserGender;
import co.edu.icesi.ci.thymeval.model.UserType;
import co.edu.icesi.ci.thymeval.service.UserService;

@SpringBootApplication
public class ThymeleafValidationApplication {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

	public static void main(String[] args) {
		
		ConfigurableApplicationContext c = SpringApplication.run(ThymeleafValidationApplication.class, args);
		UserService u = c.getBean(UserService.class);
		User user1 = new User();
		Date b = new Date(2323223232L);
		user1.setName("Juan");
		user1.setEmail("jc@gmail.com");
		user1.setGender(UserGender.femenine);
		user1.setType(UserType.doctor);
		user1.setBirthDate(convertToLocalDateViaInstant(b));
		u.save(user1);
		User user2 = new User();
		Date a = new Date(2323223232L);
		user2.setGender(UserGender.femenine);
		user2.setName("Ana");
		user2.setEmail("ana@gmail.com");
		user2.setType(UserType.patient);
		user2.setBirthDate(convertToLocalDateViaInstant(a));
		u.save(user2);
	}

	
	
}
