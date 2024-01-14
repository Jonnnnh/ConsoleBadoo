package org.example.consolegame.helpers;

public class ConsoleColors {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String WHITE= "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";

    public static void printHeader(String header) {
        System.out.println(ConsoleColors.BOLD + ConsoleColors.WHITE + header.toUpperCase() + ConsoleColors.RESET);
    }

    public static void printText(String text) {
        System.out.println(ConsoleColors.ITALIC + ConsoleColors.WHITE + text.toUpperCase() + ConsoleColors.RESET);
    }

    public static void printAnimatedText(String text) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
