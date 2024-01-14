package org.example.consolegame;

import org.example.consolegame.client.factory.PersonFactory;
import org.example.consolegame.client.factory.SimplePersonFactory;
import org.example.consolegame.client.strategy.GenderBasedRecommendationStrategy;
import org.example.consolegame.client.strategy.RecommendationStrategy;
import org.example.consolegame.helpers.ConsoleColors;
import org.example.consolegame.logic.facade.PersonManagementFacade;
import org.example.consolegame.logic.manager.ConnectionManager;
import org.example.consolegame.logic.manager.Manager;
import org.example.consolegame.logic.service.*;
import org.example.consolegame.view.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        PersonFactory personFactory = new SimplePersonFactory();
        RecommendationStrategy strategy = new GenderBasedRecommendationStrategy();

        IPersonCreationService personCreationService = new PersonCreationService(personFactory);
        RecommendationService recommendationService = new RecommendationService(strategy);
        IConnectionServiceImpl connectionService = new ConnectionServiceImpl();

        PersonManagementFacade facade = new PersonManagementFacade(
                personCreationService, recommendationService, connectionService
        );

         Manager manager = new Manager(facade);
        ConnectionManager connectionManager = new ConnectionManager(facade);

        ConsoleUI consoleUI = new ConsoleUI(manager, connectionManager);

        ConsoleColors.printAnimatedText("Добро пожаловать в Консольное Badoo!");
        consoleUI.start();
    }
}
