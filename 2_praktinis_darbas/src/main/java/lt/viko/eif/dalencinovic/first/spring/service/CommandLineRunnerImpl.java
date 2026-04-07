package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.menu.UserMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Executes application logic after Spring Boot starts.
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    /**
     * Console menu used for user interaction.
     */
    private final UserMenu userMenu;

    /**
     * Constructor-based dependency injection of {@link UserMenu}.
     *
     * @param userMenu menu component for user interaction
     */
    public CommandLineRunnerImpl(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    /**
     * Entry point method that is executed after application startup.
     *
     * @param args command-line arguments
     */
    @Override
    public void run(String... args){
        userMenu.showMenu();
    }
}
