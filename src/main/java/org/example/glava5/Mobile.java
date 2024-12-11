package org.example.glava5;
import java.util.List;
import java.util.ArrayList;

public class Mobile {
    private String brand;
    private List<Model> models;


    public Mobile(String brand) {
        this.brand = brand;
        this.models = new ArrayList<>();
    }


    public void addModel(String name, double price, String os) {
        models.add(new Model(name, price, os));
    }


    public void displayModels() {
        System.out.println("Модели бренда: " + brand);
        for (Model model : models) {
            System.out.println(model);
        }
    }

    public class Model {
        private String name;
        private double price;
        private String operatingSystem;


        public Model(String name, double price, String operatingSystem) {
            this.name = name;
            this.price = price;
            this.operatingSystem = operatingSystem;
        }


        @Override
        public String toString() {
            return "Модель: " + name + ", Цена: " + price + " USD, ОС: " + operatingSystem;
        }
    }
}
