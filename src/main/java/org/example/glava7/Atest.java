package org.example.glava7;

public class Atest {
    public static void main(String[] args) {
        // Лямбда-выражение
        TriFunction<Integer, Integer, Integer, Integer> maxOfThree = (a, b, c) ->
                a > b ? (a > c ? a : c) : (b > c ? b : c);

        // Тестируем
        int a = 10, b = 20, c = 15;
        int result = maxOfThree.apply(a, b, c);

        System.out.println("Наибольшее число: " + result);
    }

    // Функциональный интерфейс для лямбды с тремя аргументами
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}

