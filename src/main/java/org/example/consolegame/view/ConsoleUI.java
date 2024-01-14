package org.example.consolegame.view;

import org.example.consolegame.client.Person;
import org.example.consolegame.logic.manager.ConnectionManager;
import org.example.consolegame.logic.manager.Manager;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final Manager manager;
    private final ConnectionManager connectionManager;

    public ConsoleUI(Manager manager, ConnectionManager connectionManager) {
        this.scanner = new Scanner(System.in);
        this.manager = manager;
        this.connectionManager = connectionManager;
    }

    public void start() {
        int command;
        Person me = manager.inputPersonData();
        while (true) {
            manager.printMenu();
            try {
                command = scanner.nextInt();
                processCommand(command, me);
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }

    private void processCommand(int command, Person me) {
        switch (command) {
            case 1:
                System.out.println(me.getProfileCard());
                break;
            case 2:
                me = manager.inputPersonData();
                break;
            case 3:
                manager.selectRecommendation(me);
                List<Person> recommendations = manager.getRecommendations(me);
                for (Person person : recommendations) {
                    System.out.println(person.getProfileCard());
                }
                break;
            case 4:
                connectionManager.connectMeWithSomebody(scanner, me);
                break;
            case 5:
                manager.addPerson(manager.inputPersonData());
                break;
            case 6:
                me.printRelationships();
                break;
            case 0:
                System.out.println("Выход из программы...");
                System.exit(0);
                break;
            default:
                System.out.println("Нет такой команды, попробуйте еще раз");
                break;
        }
    }
}