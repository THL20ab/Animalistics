package com.company.animalistic.tool;

import java.util.Scanner;

public class InputHandler {
    private final Scanner userInput = new Scanner(System.in);

    public void clearTerminal() {
        System.out.println("\n".repeat(100));
    }

    public String prompt(String message) { System.out.print(message); return userInput.nextLine(); }

    public int promptInt(String message, int min, int max) {
        //Set initial value to be out of scope
        int number = min - 1;
        //Try to capture the Integer
        try {
            number = Integer.parseInt(prompt(message));
        } catch(Exception e) {
            System.out.println("\nYou have to enter a number between " + min + " and " + max + ".\n");
        }
        //If value is out of scope prompt again, if not return the value
        return number < min || number > max ? promptInt(message, min, max) : number;
    }

    public int menu(String[] options) {
        clearTerminal();

        for(int i = 0; i < options.length; i++) { System.out.println((i + 1) + ". " + options[i]); }

        System.out.print("\n");

        return promptInt("Choice: ", 1, options.length + 1);
    }
}
