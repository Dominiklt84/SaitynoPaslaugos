package lt.viko.eif.dalencinovic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class.
 *
 * Starts REST application.
 */
@SpringBootApplication
public class JaxRsApplication {

	/**
	 * Application entry point.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(JaxRsApplication.class, args);
	}

}
