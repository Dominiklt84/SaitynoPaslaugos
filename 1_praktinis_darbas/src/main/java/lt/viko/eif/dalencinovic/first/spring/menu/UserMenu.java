package lt.viko.eif.dalencinovic.first.spring.menu;

import lt.viko.eif.dalencinovic.first.spring.db.CarDealershipRepository;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@Component
public class UserMenu {
    @Autowired
    private CarDealershipRepository carDealershipRepository;
    @Autowired
    private XMLTransformationService xmlTransformationService;

    public UserMenu(CarDealershipRepository carDealershipRepository, XMLTransformationService xmlTransformationService) {
        this.carDealershipRepository = carDealershipRepository;
        this.xmlTransformationService = xmlTransformationService;
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
                    CarDealership carDealership=carDealershipRepository.findAll().get(0);
                    xmlTransformationService.transformToXML(carDealership, new File("car_dealership.xml"));
                    break;
                case 3:
                    try{
                        XMLValidator.validate(new File("car_dealership.xml"), new File("src/main/resources/carDealership.xsd"));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    CarDealership result = xmlTransformationService.transformToPOJO(new File("received.xml"), new File("src/main/resources/carDealership.xsd"),CarDealership.class);
                    System.out.println(result);
                    break;
                case 5:
                    new Thread(()->{
                        try {
                            lt.viko.eif.dalencinovic.first.spring.network.Server.startServer("car_dealership.xml");
                        }catch (Exception e){
                            e. printStackTrace();
                        }
                    }).start();
                    break;
                case 6:
                    try {
                        lt.viko.eif.dalencinovic.first.spring.network.Client.startClient("received.xml");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Thank you and goodbye!");
                    System.exit(0);
                    break;
            }
        }while (userChoice!=0);
    }
}
