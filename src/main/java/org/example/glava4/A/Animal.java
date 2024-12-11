package org.example.glava4.A;

public class Animal {
    private String name;


    public Animal(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void move() {
        System.out.println(name + " двигается.");
    }

    public void makeSound() {
        System.out.println(name + " издаёт звук.");
    }





    @Override
    public String toString() {
        return "Животное{" + "имя='" + name + '\'' + '}';
    }
}

