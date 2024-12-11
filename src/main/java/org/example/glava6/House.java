package org.example.glava6;



public class House implements Building, Rentable {
    private String address;
    private double area;
    private int numberOfRooms;
    private double pricePerSquareMeter;

    public House(String address, double area, int numberOfRooms, double pricePerSquareMeter) {
        this.address = address;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    @Override
    public void build() {
        System.out.println("Дом по адресу " + address + " построен!");
    }

    @Override
    public double calculatePricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public void expand(double additionalArea) {
        area += additionalArea;
        System.out.println("Площадь дома увеличена до " + area + " м²");
    }

    @Override
    public void rentOut() {
        System.out.println("Дом по адресу " + address + " сдается в аренду!");
    }

    @Override
    public void renovateRoom(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= numberOfRooms) {
            System.out.println("Ремонт комнаты №" + roomNumber + " завершен.");
        } else {
            System.out.println("Номер комнаты указан неверно!");
        }
    }

    @Override
    public String toString() {
        return "Дом [адрес='" + address + "', площадь=" + area + " м², комнаты=" + numberOfRooms + "]";
    }

    public double getArea() {
        return area;
    }

    // Сеттер для изменения значения area
    public void setArea(double area) {
        this.area = area;
    }



}
