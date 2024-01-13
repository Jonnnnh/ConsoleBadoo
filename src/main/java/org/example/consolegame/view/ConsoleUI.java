package org.example.consolegame.view;

import org.example.consolegame.client.Person;
import org.example.consolegame.logic.Manager;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final Manager manager;

    public ConsoleUI(Manager manager) {
        this.scanner = new Scanner(System.in);
        this.manager = manager;
    }

    public void start() {
        int command;
        Person me = manager.inputPersonData();
        while (true) {
            manager.printMenu();
            command = scanner.nextInt();
            processCommand(command, me);
        }
    }

    private void processCommand(int command, Person me) {
        switch (command) {
            case 1:
                System.out.println(me.getProfileCard());
                break;
            case 2:
                System.out.println("Введи информацию о себе:");
                manager.inputPersonData();
                break;
            case 3:
                for (Person person : manager.getRecommendations(me)) {
                    System.out.println(person.getProfileCard());
                }
                break;
            case 4:
                manager.connectMeWithSomebody(scanner, me);
                break;
            case 5:
                manager.addPerson(manager.inputPersonData());
                break;
            case 0:
                System.out.println("Выход из программы...");
                return;
            default:
                System.out.println("Нет такой команды, попробуйте еще раз");
        }
    }
}