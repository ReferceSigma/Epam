package main.glava3.B;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(1, -2, -3)); // Пример: 1x - 2y - 3 = 0
        lines.add(new Line(2, -4, 6)); // Пример: 2x - 4y + 6 = 0
        lines.add(new Line(0, 1, -5)); // Пример: y - 5 = 0
        lines.add(new Line(1, 0, -7)); // Пример: x - 7 = 0


        for (Line line : lines) {
            System.out.println(line);
            line.findIntersections();
            System.out.println();
        }


        System.out.println("Параллельные прямые:");
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                if (lines.get(i).isParallel(lines.get(j))) {
                    System.out.println(lines.get(i) + " || " + lines.get(j));
                }
            }
        }


        System.out.println("\nТочка пересечения двух прямых:");
        Line.findIntersection(lines.get(0), lines.get(3));
    }
}

