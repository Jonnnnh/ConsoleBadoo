package org.example.consolegame;

import org.example.consolegame.client.factory.PersonFactory;
import org.example.consolegame.client.factory.SimplePersonFactory;
import org.example.consolegame.client.strategy.GenderBasedRecommendationStrategy;
import org.example.consolegame.client.strategy.RecommendationStrategy;
import org.example.consolegame.helpers.ConsoleColors;
import org.example.consolegame.logic.manager.ConnectionManager;
import org.example.consolegame.logic.manager.Manager;
import org.example.consolegame.logic.service.PersonService;
import org.example.consolegame.logic.service.PersonServiceImpl;
import org.example.consolegame.view.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        PersonFactory personFactory = new SimplePersonFactory();
        RecommendationStrategy strategy = new GenderBasedRecommendationStrategy();
        PersonService personService = new PersonServiceImpl(personFactory, strategy);

        Manager manager = new Manager(personService, personFactory);
        ConnectionManager connectionManager = new ConnectionManager(personService);

        ConsoleUI consoleUI = new ConsoleUI(manager, connectionManager);

        ConsoleColors.printAnimatedText("Добро пожаловать в Консольное Badoo!");
        consoleUI.start();
    }
}
