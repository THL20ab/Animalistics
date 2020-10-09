package com.company.animalistic.main;

import com.company.animalistic.tool.InputHandler;

public class Game {
    private InputHandler inputHandler;
    private int numberOfPlayers, numberOfRounds;

    public Game() {
        init();
    }

    private void init() {
        inputHandler = new InputHandler();
        numberOfPlayers = inputHandler.promptInt("Enter the number of players\t(1-4)\t: ", 1, 4);
        numberOfRounds = inputHandler.promptInt("Enter the number of rounds\t(5-30)\t: ", 5, 30);
    }

    private void run() {

    }

    private void stop() {

    }

    private void update() {

    }
}
