package lt.viko.eif.dalencinovic.first.spring.menu;

import lt.viko.eif.dalencinovic.first.spring.db.CarDealershipRepository;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import lt.viko.eif.dalencinovic.first.spring.network.Client;
import lt.viko.eif.dalencinovic.first.spring.network.Server;
import lt.viko.eif.dalencinovic.first.spring.service.DTDValidator;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Console menu for interacting with application features.
 */
@Component
public class UserMenu {
    private final CarDealershipRepository carDealershipRepository;
    private final XMLTransformationService xmlTransformationService;
    private final XMLValidator xmlValidator;

    public UserMenu(CarDealershipRepository carDealershipRepository, XMLTransformationService xmlTransformationService, XMLValidator xmlValidator) {
        this.carDealershipRepository = carDealershipRepository;
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
        System.out.printf("| 3) + %10s \n", "Validate XML");
        System.out.printf("| 4) + %10s \n", "Transform XML to POJO");
        System.out.printf("| 5) + %10s \n", "Send XML to Server");
        System.out.printf("| 6) + %10s \n", "Receive XML from Client");
        System.out.printf("| 7) Quit %7s \n", " ");
        return input.nextInt();
    }

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
                    var list = carDealershipRepository.findAll();
                    if(list.isEmpty()){
                        System.out.println("Database is empty.");
                    }
                    xmlTransformationService.transformToXML(list.get(0), new File("src/main/resources/car_dealership.xml"));
                    break;
                case 3:
                    File xml = new File("src/main/resources/car_dealership.xml");
                    File xsd = new File("src/main/resources/carDealership.xsd");

                    DTDValidator.validate(xml);
                    xmlValidator.validate(xml, xsd);
                    break;
                case 4:
                    CarDealership result =
                            xmlTransformationService.transformToPOJO(
                                    new File("src/main/resources/car_dealership.xml"),
                                    new File("src/main/resources/carDealership.xsd"),
                                    CarDealership.class);
                    System.out.println(result);
                    break;
                case 5:
                    new Thread(() ->
                            Server.startServer("src/main/resources/car_dealership.xml")).start();
                    break;
                case 6:
                    Client.startClient("src/main/resources/car_dealership.xml");
                    break;
                case 7:
                    System.out.println("Thank you and goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }while (userChoice!=7);
    }
}
