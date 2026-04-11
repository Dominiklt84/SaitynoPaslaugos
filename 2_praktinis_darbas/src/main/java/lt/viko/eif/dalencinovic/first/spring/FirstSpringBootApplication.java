package lt.viko.eif.dalencinovic.first.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

/**
 * Main entry point of the Spring Boot application.
 * After startup, Spring initializes all components and
 * executes {@code CommandLineRunner}, which starts the user menu.
 */
@SpringBootApplication
@ServletComponentScan
public class FirstSpringBootApplication {

	/**
	 * Main method used to launch the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
}
