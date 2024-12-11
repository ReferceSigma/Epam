package org.example.glava4.A;

public class Dog extends Animal {


    public Dog(String name) {
        super(name);
    }


    public void bark() {
        System.out.println(getName() + " лает: Гав-гав!");
    }

    public void bite() {
        System.out.println(getName() + " кусает.");
    }

    public void run() {
        System.out.println(getName() + " бежит.");
    }

    public void jump() {
        System.out.println(getName() + " прыгает.");
    }

    @Override
    public String toString() {
        return "Собака{" + "имя='" + getName() + '\'' + '}';
    }
}

