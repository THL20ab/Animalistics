package com.company.animalistic.tool;

import java.util.Scanner;

public class Console {
    private static final int ROW_LENGTH = 128;
    private static final Scanner userInput = new Scanner(System.in);
    public static final int ORIENTATION_CENTER = 0, ORIENTATION_LEFT = 1;

    public static void out(String message, int orientation, int margin) {
        System.out.println(getMessageAsOutputString(message,orientation,margin));
    }

    public static String prompt(String message) {
        System.out.print("\n" + message);
        return userInput.nextLine();
    }

    public static int promptInt(String message, int min, int max) {
        //Set initial value to be out of scope
        int number;
        //Try to capture the Integer
        try {
            number = Integer.parseInt(prompt(message));
            return number < min || number > max ? promptInt(message, min, max) : number;
        } catch(Exception e) {
            return promptInt(message, min, max);
        }
    }

    public static int displayMenu(String[] options) {
        StringBuilder menuString = new StringBuilder("<< ");
        for(int i = 0; i < options.length; i++) { menuString.append(i + 1).append(". [").append(options[i]).append("] ").append(i < options.length - 1 ? " ><>< " : ""); }
        menuString.append(" >>");
        displayInBox(new String[] {menuString.toString()}, ORIENTATION_CENTER, 0);
        return promptInt("Choice: ", 1, options.length);
    }

    public static void displayInBox(String[] rows, int orientation, int margin) {
        boxStart();
        for (String row : rows) { out(row, orientation, margin); }
        boxEnd();
    }

    public static String getMessageAsOutputString(String message, int orientation, int margin) {
        String output = "|" + " ".repeat(ROW_LENGTH - 2) + "|";
        if(orientation == ORIENTATION_LEFT) {
            output = output.substring(0,margin) + message + output.substring(margin + message.length());
        }
        if(orientation == ORIENTATION_CENTER) {
            margin = (output.length() - message.length()) / 2;
            output = output.substring(0, margin) + message + output.substring(margin + message.length());
        }
        return output;
    }

    public static void boxStart () { System.out.println("." + "-".repeat(ROW_LENGTH - 2) + "."); }
    public static void boxEnd() { System.out.println("'" + "-".repeat(ROW_LENGTH - 2) + "'"); }
}
