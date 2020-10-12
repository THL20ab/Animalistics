package com.company.animalistic.main;

import com.company.animalistic.gameobject.Player;
import com.company.animalistic.tool.Console;

import java.util.ArrayList;

public class Game {
    public static final String TITLE = "ANIMALISTICS DEVELOPMENT VERSION";

    private ArrayList<Player> players;
    private int numberOfPlayers, numberOfRounds;

    private boolean running;

    public Game() {
        init();
    }

    private void init() {
        players = new ArrayList<>();
        numberOfPlayers = 0;
        numberOfRounds = 0;

        stop();
        displayTitle();
        displayMainMenu();
    }

    private void run() {
        if(!isRunning()) { running = true; }
        while(isRunning()) {
            update();
        }
    }

    private void stop() { if(isRunning()) { running = false; } }

    private void update() {
        setNumberOfPlayers(Console.promptInt("Enter number of players\t[1-4]:\t",1,4));
        setNumberOfRounds(Console.promptInt("Enter nuber of rounds\t[5-30]:\t",5,30));

        for(int round = 0; round < numberOfRounds; round++) {
            for(int playersTurn = 0; playersTurn < numberOfPlayers; playersTurn++) {
                if(round == 0) { players.add(new Player(Console.prompt("Please enter a name for player " + (playersTurn + 1) + ": "), 0)); }
                Console.displayInBox(new String[] { "Round " + (round + 1) + ", your turn " + players.get(playersTurn).getName() + " :)", "What would you like to do?" }, Console.ORIENTATION_CENTER,4);
                displayPlayerMenu();
            }
        }
    }

    private void displayTitle() {
        Console.displayInBox(new String[] { TITLE }, Console.ORIENTATION_CENTER, 0);
    }

    private void displayMainMenu() {
        int choice = Console.displayMenu(new String[] {"New Game", "Help", "Stop Game", "Exit"});
        switch (choice) {
            case 1 -> run();
            case 2 -> System.out.println("This will be the help section");
            case 3 -> System.out.println("Sorry to see you go :/ Hope you'll be back soon :)");
        }
    }

    private void displayPlayerMenu() {
        Console.displayMenu(new String[]{"Visit Store", "Feed Animal", "Breed Animals"});
    }

    private void setNumberOfPlayers(int numberOfPlayers) { this.numberOfPlayers = numberOfPlayers; }
    private void setNumberOfRounds(int numberOfRounds) { this.numberOfRounds = numberOfRounds; }

    public boolean isRunning() { return running; }
}
