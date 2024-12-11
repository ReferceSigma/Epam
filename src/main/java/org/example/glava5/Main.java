package org.example.glava5;



public class Main {
    public static void main(String[] args) {

        Mobile samsung = new Mobile("Samsung");


        samsung.addModel("Galaxy S23", 999.99, "Android");
        samsung.addModel("Galaxy A54", 499.99, "Android");


        Mobile apple = new Mobile("Apple");


        apple.addModel("iPhone 14", 1199.99, "iOS");
        apple.addModel("iPhone SE", 429.99, "iOS");


        samsung.displayModels();
        System.out.println();
        apple.displayModels();
    }
}

