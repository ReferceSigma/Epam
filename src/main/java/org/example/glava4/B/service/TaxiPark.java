package main.glava4.B.service;



import main.glava4.B.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiPark {
    private List<Car> cars;


    public TaxiPark(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }


    public void addCar(Car car) {
        cars.add(car);
    }


    public double calculateTotalCost() {
        return cars.stream().mapToDouble(Car::getPrice).sum();
    }


    public void sortByFuelConsumption() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }


    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                result.add(car);
            }
        }
        return result;
    }


    public void printCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

