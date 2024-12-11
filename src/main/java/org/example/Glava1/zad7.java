package org.example.Glava1;

import java.util.*;
import static java.util.Collections.*;

public class zad7 {
    private static List<Integer> divider(int divider, Integer[] array) {
        List<Integer> divided = new LinkedList<Integer>();
        for (Integer anArray : array) {
            if (anArray % divider == 0)
                divided.add(anArray);
        }
        return divided;
    }

    private static Map revSortByVal(Map<Integer, Integer> map) {
        List<Object> list = new LinkedList<Object>(map.entrySet());
        sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map result = new LinkedHashMap();
        for (Object aList : list) {
            Map.Entry entry = (Map.Entry) aList;
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    private static List<Integer> list1 = new LinkedList<Integer>();
    private static List<Integer> list2 = new LinkedList<Integer>();

    public static List<Integer> primeNums(Integer[] input) {
        list1.clear();
        for (Integer anInput : input) {
            if (isPrimeNum(anInput)) {
                list1.add(anInput);
            }
        }
        return list1;
    }

    public static boolean isPrimeNum(int n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return (n % 2 != 0 && prime && n > 2) || n == 2;
    }

    private static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private static Map<Integer, Integer> invMap = new TreeMap<Integer, Integer>();

    private static void put(Integer key, Integer value) {
        map.put(key, value);
        invMap.put(value, key);
    }


    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        if (size == 0) {
            System.out.print("Программа завершена.");
            System.exit(0);
        }
        Integer[] numbers = new Integer[size];
        System.out.print("Введите целые числа через пробел "
                + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++)
            numbers[i] = in.nextInt();

        // 1.
        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0)
                list1.add(numbers[i]);
            else
                list2.add(numbers[i]);
        }
        System.out.println("Чётные числа: " + list1);
        System.out.println("Нечётные числа: " + list2);

        // 2.
        List<Integer> listFromArray = Arrays.asList(numbers);
        System.out.println("Наибольшее число: " + max(listFromArray));
        System.out.println("Наименьшее число: " + min(listFromArray));

        // 3.
        System.out.println("Числа, которые делятся на 3: "
                + divider(3, numbers));
        System.out.println("Числа, которые делятся на 9: "
                + divider(9, numbers));

        // 4.
        System.out.println("Числа, которые делятся на 5: "
                + divider(5, numbers));
        System.out.println("Числа, которые делятся на 7: "
                + divider(7, numbers));

        // 5.
        String num;
        list1.clear();
        for (int i = 0; i < size; i++) {
            num = numbers[i].toString();
            if (num.length() == 3 && num.charAt(0) != num.charAt(1)
                    && num.charAt(1) != num.charAt(2)
                    && num.charAt(0) != num.charAt(2))
                list1.add(numbers[i]);
        }
        System.out.println("Все трехзначные числа, "
                + "в десятичной записи которых нет одинаковых цифр: " + list1);


        // 6.
        System.out.println("Простые числа: " + primeNums(numbers));

        // 7.
        list1.clear();
        list1.addAll(listFromArray);
        sort(list1);
        System.out.println("Отсортированные числа в порядке возрастания: "
                + list1);
        reverse(list1);
        System.out
                .println("Отсортированные числа в порядке убывания: " + list1);

        // 8.
        for (Integer i : numbers) {
            put(i, frequency(listFromArray, i));
        }
        System.out.println("Числа в порядке убывания частоты встречаемости "
                + "чисел: " + revSortByVal(map));

        // 9.
        list1.clear();
        for (int i = 0; i < size; i++) {
            num = numbers[i].toString();
            if (num.length() == 4
                    && num.charAt(0) + num.charAt(1) == num.charAt(2)
                    + num.charAt(3))
                list1.add(numbers[i]);
        }
        System.out.println("“Счастливые” числа: " + list1);


        // 10.
        List<StringBuilder> palindromes = new LinkedList<StringBuilder>();
        for (int i = 0; i < size; i++) {
            StringBuilder s = new StringBuilder(numbers[i].toString());
            if (s.toString().equals(s.reverse().toString()))
                palindromes.add(s);
        }
        System.out.println("Числа-палиндромы: " + palindromes);

        // 11.
        list1.clear();
        Integer[] int2;
        int2 = numbers.clone();
        for (int i = 1; i < int2.length - 1; i++) {
            if (int2.length < 3)
                break;
            if (int2[i] == (int2[i - 1] + int2[i + 1]) / 2)
                list1.add(int2[i]);
        }
        System.out.println("Элементы, которые равны полусумме соседних "
                + "элементов: " + list1);


    }}