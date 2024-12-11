package main.glava4.B.app;



import main.glava4.B.data.TaxiParkInitializer;
import main.glava4.B.model.Car;
import main.glava4.B.service.TaxiPark;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sulti\\IdeaProjects\\JavaEpam\\src\\main\\glava4\\B\\cars.txt.txt";
        List<Car> cars = TaxiParkInitializer.initializeFromFile(filePath);
        TaxiPark taxiPark = new TaxiPark(cars);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Вывести список автомобилей");
            System.out.println("2. Подсчитать стоимость автопарка");
            System.out.println("3. Отсортировать автомобили по расходу топлива");
            System.out.println("4. Найти автомобили по диапазону скорости");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nСписок автомобилей:");
                    taxiPark.printCars();
                    break;
                case 2:
                    System.out.println("\nОбщая стоимость автопарка: " + taxiPark.calculateTotalCost() + " USD");
                    break;
                case 3:
                    taxiPark.sortByFuelConsumption();
                    System.out.println("\nАвтомобили отсортированы по расходу топлива:");
                    taxiPark.printCars();
                    break;
                case 4:
                    System.out.print("\nВведите минимальную скорость: ");
                    int minSpeed = scanner.nextInt();
                    System.out.print("Введите максимальную скорость: ");
                    int maxSpeed = scanner.nextInt();
                    List<Car> foundCars = taxiPark.findCarsBySpeedRange(minSpeed, maxSpeed);
                    System.out.println("\nАвтомобили в заданном диапазоне скорости:");
                    for (Car car : foundCars) {
                        System.out.println(car);
                    }
                    break;
                case 0:
                    System.out.println("\nВыход из программы...");
                    return;
                default:
                    System.out.println("\nНекорректный ввод. Попробуйте снова.");
            }
        }
    }
}

