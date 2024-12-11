package main.glava4.B.data;


import main.glava4.B.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaxiParkInitializer {


    public static List<Car> initializeFromFile(String filePath) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");


                String type = parts[0];
                String brand = parts[1];
                String model = parts[2];
                double price = Double.parseDouble(parts[3]);
                double fuelConsumption = Double.parseDouble(parts[4]);
                int maxSpeed = Integer.parseInt(parts[5]);

                switch (type) {
                    case "Sedan":
                        cars.add(new Sedan(brand, model, price, fuelConsumption, maxSpeed));
                        break;
                    case "SUV":
                        cars.add(new SUV(brand, model, price, fuelConsumption, maxSpeed));
                        break;
                    case "Hatchback":
                        cars.add(new Hatchback(brand, model, price, fuelConsumption, maxSpeed));
                        break;
                    default:
                        System.out.println("Неизвестный тип автомобиля: " + type);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return cars;
    }
}

