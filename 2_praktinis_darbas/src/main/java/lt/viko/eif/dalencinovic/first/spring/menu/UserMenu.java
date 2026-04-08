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

/**
 * Console menu for interacting with application features.
 * Allows database fetch, XML transformation, validation,
 * and network transmission of XML file.
 */
@Component
public class UserMenu {
    private final RestaurantRepository restaurantRepository;
    private final XMLTransformationService xmlTransformationService;
    private final XMLValidator xmlValidator;

    private static final String XML_PATH = "src/main/resources/restaurant.xml";
    private static final String XSD_PATH = "src/main/resources/restaurant.xsd";

    public UserMenu(RestaurantRepository restaurantRepository, XMLTransformationService xmlTransformationService, XMLValidator xmlValidator) {
        this.restaurantRepository = restaurantRepository;
        this.xmlTransformationService = xmlTransformationService;
        this.xmlValidator = xmlValidator;
    }

    /**
     * Displays menu and returns user selection.
     */
    private int displayMenu(Scanner input) {
        System.out.println(" \n" +
                "██    ██ ███████ ███████ ██████      ███    ███ ███████ ███    ██ ██    ██\n" +
                "██    ██ ██      ██      ██   ██     ████  ████ ██      ████   ██ ██    ██\n" +
                "██    ██ ███████ █████   ██████      ██ ████ ██ █████   ██ ██  ██ ██    ██\n" +
                "██    ██      ██ ██      ██   ██     ██  ██  ██ ██      ██  ██ ██ ██    ██\n" +
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

    /**
     * Executes full workflow:
     * DB → XML → Unmarshal-> DTD → XSD → HTML → PDF.
     */
    private void runFullWorkflow() {
        try {
            System.out.println("\n===== FULL WORKFLOW STARTED=====");

            // 1. Fetch from DB
            System.out.println("1) Fetching data from database...");
            List<Restaurant> list = restaurantRepository.findAll();
            if (list.isEmpty()) {
                System.out.println("Database is empty.");
                return;
            }
            System.out.println("Data fetched from DB.");

            // 2. Transform to XML
            System.out.println("2) Transforming POJO to XML...");
            File xmlFile = new File(XML_PATH);
            RestaurantList wrapper = new RestaurantList(list);

            xmlTransformationService.transformToXML(wrapper, xmlFile);

            // 3. Transform to POJO
            RestaurantList result = xmlTransformationService.transformToPOJO(
                    xmlFile,
                    new File(XSD_PATH),
                    RestaurantList.class);
            System.out.println("3) Transforming XML to POJO");
            result.getRestaurants().forEach(System.out::println);

            // 4. Validate against DTD
            System.out.println("4) Validating XML against DTD...");
            DTDValidator.validate(xmlFile);

            // 5. Validate against XSD
            System.out.println("5) Validating XML against XSD...");
            xmlValidator.validate(xmlFile, new File(XSD_PATH));

            // 6. Transform to HTML
            System.out.println("6) Transforming XML to HTML");
            xmlTransformationService.transformToHTML(
                    xmlFile,
                    new File("src/main/resources/restaurant-to-html.xsl"),
                    new File("restaurant2.html"));

            // 7. Transform to PDF
            System.out.println("7) Transforming XML to PDF");
            xmlTransformationService.transformToPDF(
                    xmlFile,
                    new File("src/main/resources/restaurant-to-pdf.xsl"),
                    new File("restaurant2.pdf")
            );

            System.out.println("===== FULL WORKFLOW FINISHED SUCCESSFULLY =====\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts interactive console menu.
     */
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
                    RestaurantList result = xmlTransformationService.transformToPOJO(
                            new File(XML_PATH),
                            new File(XSD_PATH),
                            RestaurantList.class
                    );
                    System.out.println(result.getRestaurants());
                    break;

                case 5:
                    xmlTransformationService.transformToHTML(
                            new File(XML_PATH),
                            new File("src/main/resources/restaurant-to-html.xsl"),
                            new File("restaurant1.html")
                    );
                    break;

                case 6:
                    xmlTransformationService.transformToPDF(
                            new File(XML_PATH),
                            new File("src/main/resources/restaurant-to-pdf.xsl"),
                            new File("restaurant1.pdf")
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
