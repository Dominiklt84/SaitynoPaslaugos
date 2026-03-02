package lt.viko.eif.dalencinovic.first.spring.menu;

import lt.viko.eif.dalencinovic.first.spring.db.CarDealershipRepository;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import lt.viko.eif.dalencinovic.first.spring.network.Client;
import lt.viko.eif.dalencinovic.first.spring.network.Server;
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
    private final CarDealershipRepository carDealershipRepository;
    private final XMLTransformationService xmlTransformationService;
    private final XMLValidator xmlValidator;

    private static final String XML_PATH = "src/main/resources/car_dealership.xml";
    private static final String RECEIVED_PATH = "src/main/resources/received.xml";
    private static final String XSD_PATH = "src/main/resources/carDealership.xsd";

    public UserMenu(CarDealershipRepository carDealershipRepository, XMLTransformationService xmlTransformationService, XMLValidator xmlValidator) {
        this.carDealershipRepository = carDealershipRepository;
        this.xmlTransformationService = xmlTransformationService;
        this.xmlValidator = xmlValidator;
    }

    /**
     * Displays menu and returns user selection.
     */
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
        System.out.printf("| 5) + %10s \n", "Start Server (send XML)");
        System.out.printf("| 6) + %10s \n", "Start Client (receive XML)");
        System.out.printf("| 7) + %10s \n", "Run full workflow");
        System.out.printf("| 8) Quit %7s \n", " ");
        return input.nextInt();
    }

    /**
     * Executes full workflow:
     * DB → XML → DTD → XSD → Server → Client → Unmarshal.
     */
    private void runFullWorkflow(){
        try {
            System.out.println("\n===== FULL WORKFLOW WITH NETWORK STARTED =====");

            // 1. Fetch from DB
            System.out.println("1) Fetching data from database...");
            List<CarDealership> list=carDealershipRepository.findAll();
            if(list.isEmpty()){
                System.out.println("Database is empty.");
                return;
            }
            CarDealership dealership = list.get(0);
            System.out.println("Data fetched from DB.");

            // 2. Transform to XML
            System.out.println("2) Transforming POJO to XML...");
            File xmlFile = new File(XML_PATH);
            xmlTransformationService.transformToXML(dealership, xmlFile);

            // 3. Validate against DTD
            System.out.println("3) Validating XML against DTD...");
            DTDValidator.validate(xmlFile);

            // 4. Validate against XSD
            System.out.println("4) Validating XML against XSD...");
            xmlValidator.validate(xmlFile, new File(XSD_PATH));

            // 5. Start server
            System.out.println("5) Starting server...");
            new Thread(() -> {
                try {
                    Server.startServer(XML_PATH);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(500);

            // 6. Start client
            System.out.println("6) Receiving XML via client...");
            Client.startClient(RECEIVED_PATH);

            // 7. Transform received XML to POJO
            System.out.println("7) Transforming received XML to POJO...");
            CarDealership result =
                    xmlTransformationService.transformToPOJO(
                            new File(RECEIVED_PATH),
                            new File(XSD_PATH),
                            CarDealership.class
                    );

            System.out.println("Transformation successful.");
            System.out.println("Received object:");
            System.out.println(result);

            System.out.println("===== FULL WORKFLOW FINISHED SUCCESSFULLY =====\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts interactive console menu.
     */
    public void showMenu(){
        Scanner input = new Scanner(System.in);
        int userChoice;
        do{
            userChoice=displayMenu(input);
            switch (userChoice){
                case 1:
                    carDealershipRepository.findAll().forEach(System.out::println);
                    break;
                case 2:
                    List<CarDealership> list = carDealershipRepository.findAll();
                    if(list.isEmpty()){
                        System.out.println("Database is empty.");
                    }
                    xmlTransformationService.transformToXML(list.get(0), new File(XML_PATH));
                    break;
                case 3:
                    File xml = new File(XML_PATH);
                    File xsd = new File(XSD_PATH);

                    DTDValidator.validate(xml);
                    xmlValidator.validate(xml, xsd);
                    break;
                case 4:
                    CarDealership result =
                            xmlTransformationService.transformToPOJO(
                                    new File(XML_PATH),
                                    new File(XSD_PATH),
                                    CarDealership.class);
                    System.out.println(result);
                    break;
                case 5:
                    new Thread(() ->
                            Server.startServer(XML_PATH)).start();
                    break;
                case 6:
                    Client.startClient(RECEIVED_PATH);
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
                    break;
            }
        }while (userChoice!=8);
    }
}
