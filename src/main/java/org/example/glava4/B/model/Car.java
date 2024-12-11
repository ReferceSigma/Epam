package main.glava4.B.model;

public abstract class Car {
    private String brand;
    private String model;
    private double price;
    private double fuelConsumption; // литры на 100 км
    private int maxSpeed;

    // Конструктор
    public Car(String brand, String model, double price, double fuelConsumption, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Double.compare(car.price, price) == 0 &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                maxSpeed == car.maxSpeed &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }



    @Override
    public String toString() {
        return "Автомобиль{" +
                "марка='" + brand + '\'' +
                ", модель='" + model + '\'' +
                ", цена=" + price +
                ", расход топлива=" + fuelConsumption +
                " л/100км, макс. скорость=" + maxSpeed +
                " км/ч}";
    }
}