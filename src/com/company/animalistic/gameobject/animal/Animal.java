package com.company.animalistic.gameobject.animal;

import com.company.animalistic.constant.Gender;

public abstract class Animal {
    private Gender gender;
    private String name;
    private int health;

    public Animal(Gender gender, String name, int health) {

    }

    //Getters
    public Gender getGender() { return gender; }
    public String getName() { return name; }
    public int getHealth() { return health; }

    //Setters
    public void setGender(Gender gender) { this.gender = gender; }
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
}
