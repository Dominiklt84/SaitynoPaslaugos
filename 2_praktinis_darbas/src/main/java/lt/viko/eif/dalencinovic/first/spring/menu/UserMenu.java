package lt.viko.eif.dalencinovic.first.spring.menu;

import lt.viko.eif.dalencinovic.first.spring.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserMenu {
    private final RestaurantRepository restaurantRepository;
    private final XMLTransformationService xmlTransformationService;
    private final XMLValidator xmlValidator;

    private static final String XML_PATH = "src/main/resources/restaurant.xml";
    private static final String XSD_PATH="src/main/resources/restaurant.xsd";

    public UserMenu(RestaurantRepository restaurantRepository, XMLTransformationService xmlTransformationService, XMLValidator xmlValidator) {
        this.restaurantRepository = restaurantRepository;
        this.xmlTransformationService = xmlTransformationService;
        this.xmlValidator = xmlValidator;
    }

    private int displayMenu(Scanner input){
        System.out.println(" \n"+
                "██    ██ ███████ ███████ ██████      ███    ███ ███████ ███    ██ ██    ██\n"+
                "██    ██ ██      ██      ██   ██     ████  ████ ██      ████   ██ ██    ██\n"+
                "██    ██ ███████ █████   ██████      ██ ████ ██ █████   ██ ██  ██ ██    ██\n"+
                "██    ██      ██ ██      ██   ██     ██  ██  ██ ██      ██  ██ ██ ██    ██\n"+
                " ██████  ███████ ███████ ██   ██     ██      ██ ███████ ██   ████  ██████");
        System.out.println(" Make a selection ");
        System.out.println("-------------------");
        System.out.printf("| 1) + %10s \n", "Fetch data from DB ");
        System.out.printf("| 2) + %10s \n", "Transform to XML");
        System.out.printf("| 3) + %10s \n", "Validate XML (DTD+XSD)");
        System.out.printf("| 4) + %10s \n", "Transform XML to POJO");
        System.out.printf("| 5) + %10s \n", "Transform XML to HTML");
        System.out.printf("| 6) + %10s \n", "Transform XML to PDF");
        System.out.printf("| 7) + %10s \n", "Run full workflow");
        System.out.printf("| 8) Quit %7s \n", " ");
        return input.nextInt();

    }
}
