package main.glava3.B;

public class Line {
    private double A;
    private double B;
    private double C;


    public Line(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }


    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }


    public void findIntersections() {
        if (A != 0) {
            double x = -C / A;
            System.out.println("Пересечение с осью X: (" + x + ", 0)");
        } else {
            System.out.println("Прямая параллельна оси X.");
        }

        if (B != 0) {
            double y = -C / B;
            System.out.println("Пересечение с осью Y: (0, " + y + ")");
        } else {
            System.out.println("Прямая параллельна оси Y.");
        }
    }


    public static void findIntersection(Line l1, Line l2) {
        double determinant = l1.A * l2.B - l2.A * l1.B;

        if (determinant == 0) {
            System.out.println("Прямые параллельны или совпадают.");
        } else {
            double x = (l2.B * l1.C - l1.B * l2.C) / determinant;
            double y = (l1.A * l2.C - l2.A * l1.C) / determinant;
            System.out.println("Точка пересечения: (" + x + ", " + y + ")");
        }
    }


    public boolean isParallel(Line other) {
        return (this.A * other.B == this.B * other.A);
    }

    @Override
    public String toString() {
        return "Прямая: " + A + "x + " + B + "y + " + C + " = 0";
    }
}

