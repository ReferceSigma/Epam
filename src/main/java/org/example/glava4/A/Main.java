package org.example.glava4.A;

public class Main {
    public static void main(String[] args) {

        Puppy puppy = new Puppy("Барсик");


        System.out.println("Имя щенка: " + puppy.getName());


        puppy.bark();
        puppy.jump();
        puppy.run();
        puppy.bite();
        puppy.whine();
        puppy.makeSound();
        puppy.move();


        Puppy anotherPuppy = new Puppy("Барсик");


    }
}

