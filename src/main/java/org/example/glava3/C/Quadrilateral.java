package main.glava3.C;

public class Quadrilateral {
    private Point p1, p2, p3, p4;

    // Конструктор
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // Вычисление периметра
    public double getPerimeter() {
        return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p4) + p4.distanceTo(p1);
    }

    // Вычисление площади
    public double getArea() {
        return Math.abs(
                (p1.getX() * p2.getY() + p2.getX() * p3.getY() + p3.getX() * p4.getY() + p4.getX() * p1.getY()) -
                        (p1.getY() * p2.getX() + p2.getY() * p3.getX() + p3.getY() * p4.getX() + p4.getY() * p1.getX())
        ) / 2.0;
    }

    // Определение типа
    public String getType() {
        double d1 = p1.distanceTo(p2);
        double d2 = p2.distanceTo(p3);
        double d3 = p3.distanceTo(p4);
        double d4 = p4.distanceTo(p1);
        double diag1 = p1.distanceTo(p3);
        double diag2 = p2.distanceTo(p4);

        if (d1 == d2 && d2 == d3 && d3 == d4) {
            if (diag1 == diag2) {
                return "Квадрат";
            } else {
                return "Ромб";
            }
        } else if (d1 == d3 && d2 == d4 && diag1 == diag2) {
            return "Прямоугольник";
        } else {
            return "Произвольный";
        }
    }

    @Override
    public String toString() {
        return "Четырёхугольник: {" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }
}

