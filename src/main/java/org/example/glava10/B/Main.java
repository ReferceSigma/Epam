package org.example.glava10.B;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем салат
        Salad salad = new Salad();

        // Добавляем ингредиенты
        salad.addIngredient(new Tomato(200)); // Помидор, 200г
        salad.addIngredient(new Cucumber(150)); // Огурец, 150г
        salad.addIngredient(new Oil(50)); // Масло, 50г

        // Выводим ингредиенты салата
        System.out.println("Ингредиенты салата:");
        salad.getIngredients().forEach(System.out::println);

        // Считаем общую калорийность
        System.out.println("Общая калорийность салата: " + salad.getTotalCalories() + " ккал");

        // Сортируем ингредиенты по весу
        salad.sortIngredientsByWeight();
        System.out.println("\nИнгредиенты после сортировки по весу:");
        salad.getIngredients().forEach(System.out::println);

        // Поиск овощей в диапазоне калорий
        double minCalories = 10;
        double maxCalories = 100;
        List<Vegetable> filteredVegetables = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        System.out.println("\nОвощи с калорийностью от " + minCalories + " до " + maxCalories + " ккал:");
        filteredVegetables.forEach(System.out::println);

        // Сохраняем салат в файл
        String filename = "salad.ser";
        SaladConnector.saveSalad(salad, filename);

        // Загружаем салат из файла
        Salad loadedSalad = SaladConnector.loadSalad(filename);
        if (loadedSalad != null) {
            System.out.println("\nЗагруженный салат из файла:");
            System.out.println(loadedSalad);
        }
    }
}