package main.glava3.C;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Список четырёхугольников
        List<Quadrilateral> quads = new ArrayList<>();
        quads.add(new Quadrilateral(new Point(0, 0), new Point(4, 0), new Point(4, 4), new Point(0, 4))); // Квадрат
        quads.add(new Quadrilateral(new Point(0, 0), new Point(6, 0), new Point(6, 3), new Point(0, 3))); // Прямоугольник
        quads.add(new Quadrilateral(new Point(0, 0), new Point(3, 0), new Point(2, 2), new Point(-1, 2))); // Ромб
        quads.add(new Quadrilateral(new Point(0, 0), new Point(5, 0), new Point(4, 2), new Point(1, 3))); // Произвольный

        // Подсчёт типов
        int squares = 0, rectangles = 0, rhombuses = 0, others = 0;
        for (Quadrilateral quad : quads) {
            String type = quad.getType();
            switch (type) {
                case "Квадрат": squares++; break;
                case "Прямоугольник": rectangles++; break;
                case "Ромб": rhombuses++; break;
                default: others++; break;
            }
            System.out.println(quad + " Тип: " + type + ", Площадь: " + quad.getArea() + ", Периметр: " + quad.getPerimeter());
        }

        System.out.println("\nТипы четырёхугольников:");
        System.out.println("Квадраты: " + squares);
        System.out.println("Прямоугольники: " + rectangles);
        System.out.println("Ромбы: " + rhombuses);
        System.out.println("Произвольные: " + others);

        // Поиск минимального и максимального по площади
        Quadrilateral minAreaQuad = quads.get(0), maxAreaQuad = quads.get(0);
        Quadrilateral minPerimeterQuad = quads.get(0), maxPerimeterQuad = quads.get(0);
        for (Quadrilateral quad : quads) {
            if (quad.getArea() < minAreaQuad.getArea()) minAreaQuad = quad;
            if (quad.getArea() > maxAreaQuad.getArea()) maxAreaQuad = quad;
            if (quad.getPerimeter() < minPerimeterQuad.getPerimeter()) minPerimeterQuad = quad;
            if (quad.getPerimeter() > maxPerimeterQuad.getPerimeter()) maxPerimeterQuad = quad;
        }

        System.out.println("\nМинимальная площадь: " + minAreaQuad + " (" + minAreaQuad.getArea() + ")");
        System.out.println("Максимальная площадь: " + maxAreaQuad + " (" + maxAreaQuad.getArea() + ")");
        System.out.println("Минимальный периметр: " + minPerimeterQuad + " (" + minPerimeterQuad.getPerimeter() + ")");
        System.out.println("Максимальный периметр: " + maxPerimeterQuad + " (" + maxPerimeterQuad.getPerimeter() + ")");
    }
}

