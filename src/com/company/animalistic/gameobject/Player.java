package com.company.animalistic.gameobject;

public class Player {
    private String name;
    private int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //Getters
    public String getName() { return name; }
    public int getMoney() { return money; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setMoney(int money) { this.money = money; }
}
