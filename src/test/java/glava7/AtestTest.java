package glava7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtestTest {

    // Лямбда-выражение для нахождения максимального из трех чисел
    private final TriFunction<Integer, Integer, Integer, Integer> maxOfThree =
            (a, b, c) -> a > b ? (a > c ? a : c) : (b > c ? b : c);

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    // Юнит-тесты
    @Test
    public void testMaxOfThree_AllDifferent() {
        System.out.println("Тест: Все числа разные (1, 10, 5), ожидается максимум: 10");
        assertEquals(10, maxOfThree.apply(1, 10, 5));

        System.out.println("Тест: Все числа разные (5, 10, 15), ожидается максимум: 15");
        assertEquals(15, maxOfThree.apply(5, 10, 15));

        System.out.println("Тест: Все числа разные (7, 3, 1), ожидается максимум: 7");
        assertEquals(7, maxOfThree.apply(7, 3, 1));
    }

    @Test
    public void testMaxOfThree_NegativeNumbers() {
        System.out.println("Тест: Все числа отрицательные (-10, -1, -5), ожидается максимум: -1");
        assertEquals(-1, maxOfThree.apply(-10, -1, -5));

        System.out.println("Тест: Все числа отрицательные (-7, -3, -10), ожидается максимум: -3");
        assertEquals(-3, maxOfThree.apply(-7, -3, -10));
    }

    @Test
    public void testMaxOfThree_MixedNumbers() {
        System.out.println("Тест: Смешанные числа (-50, 100, 0), ожидается максимум: 100");
        assertEquals(100, maxOfThree.apply(-50, 100, 0));

        System.out.println("Тест: Смешанные числа (-10, 0, -1), ожидается максимум: 0");
        assertEquals(0, maxOfThree.apply(-10, 0, -1));
    }

    @Test
    public void testMaxOfThree_BoundaryValues() {
        System.out.println("Тест: Граничные значения (Integer.MIN_VALUE, 0, Integer.MAX_VALUE), ожидается максимум: Integer.MAX_VALUE");
        assertEquals(Integer.MAX_VALUE, maxOfThree.apply(Integer.MIN_VALUE, 0, Integer.MAX_VALUE));

        System.out.println("Тест: Граничные значения (0, -1, -2), ожидается максимум: 0");
        assertEquals(0, maxOfThree.apply(0, -1, -2));
    }
}