package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.menu.UserMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Executes application logic after Spring Boot starts.
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final UserMenu userMenu;

    public CommandLineRunnerImpl(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    @Override
    public void run(String... args){
        userMenu.showMenu();
    }
}
