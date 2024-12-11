package org.example.glava6;



public class ShoppingCenter extends House {
    private int numberOfShops;

    public ShoppingCenter(String address, double area, int numberOfRooms, double pricePerSquareMeter, int numberOfShops) {
        super(address, area, numberOfRooms, pricePerSquareMeter);
        this.numberOfShops = numberOfShops;
    }

    public void hostEvent(String event) {
        System.out.println("В торговом центре проходит мероприятие: " + event);
    }

    @Override
    public String toString() {
        return super.toString() + ", магазинов=" + numberOfShops;
    }
}
