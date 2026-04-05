package lt.viko.eif.dalencinovic.first.spring.menu;

import lt.viko.eif.dalencinovic.first.spring.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;
import lt.viko.eif.dalencinovic.first.spring.model.RestaurantList;
import lt.viko.eif.dalencinovic.first.spring.service.DTDValidator;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
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

    private void runFullWorkflow() {
        try {
            System.out.println("\n===== FULL WORKFLOW =====");

            List<Restaurant> list = restaurantRepository.findAll();
            if (list.isEmpty()) {
                System.out.println("Database is empty.");
                return;
            }

            Restaurant restaurant = list.get(0);
            System.out.println("Data fetched from DB.");

            File xmlFile = new File(XML_PATH);
            xmlTransformationService.transformToXML(restaurant, xmlFile);

            DTDValidator.validate(xmlFile);

            xmlValidator.validate(xmlFile, new File(XSD_PATH));

            xmlTransformationService.transformToHTML(
                    xmlFile,
                    new File("src/main/resources/xsl/restaurant.xsl"),
                    new File("output.html")
            );

            xmlTransformationService.transformToPDF(
                    xmlFile,
                    new File("src/main/resources/xsl/restaurant-fo.xsl"),
                    new File("output.pdf")
            );

            Restaurant result =
                    xmlTransformationService.transformToPOJO(
                            xmlFile,
                            new File(XSD_PATH),
                            Restaurant.class
                    );

            System.out.println("Result object:");
            System.out.println(result);

            System.out.println("===== DONE =====\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            choice = displayMenu(input);

            switch (choice) {
                case 1:
                    restaurantRepository.findAll().forEach(System.out::println);
                    break;

                case 2:
                    List<Restaurant> list = restaurantRepository.findAll();
                    if (list.isEmpty()) {
                        System.out.println("Database is empty.");
                        break;
                    }

                    File xmlFile = new File(XML_PATH);
                    RestaurantList wrapper = new RestaurantList(list);
                    xmlTransformationService.transformToXML(wrapper, xmlFile);
                    break;

                case 3:
                    File xml = new File(XML_PATH);
                    File xsd = new File(XSD_PATH);

                    DTDValidator.validate(xml);
                    xmlValidator.validate(xml, xsd);
                    break;

                case 4:
                    Restaurant result =
                            xmlTransformationService.transformToPOJO(
                                    new File(XML_PATH),
                                    new File(XSD_PATH),
                                    Restaurant.class
                            );
                    System.out.println(result);
                    break;

                case 5:
                    xmlTransformationService.transformToHTML(
                            new File(XML_PATH),
                            new File("src/main/resources/restaurant-to-html.xsl"),
                            new File("output.html")
                    );
                    break;

                case 6:
                    xmlTransformationService.transformToPDF(
                            new File(XML_PATH),
                            new File("src/main/resources/restaurant-to-pdf.xsl"),
                            new File("output.pdf")
                    );
                    break;

                case 7:
                    runFullWorkflow();
                    break;

                case 8:
                    System.out.println("Thank you and goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 8);
    }
}
