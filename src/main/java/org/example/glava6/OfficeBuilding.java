package org.example.glava6;


public class OfficeBuilding extends House {
    private int numberOfOffices;

    public OfficeBuilding(String address, double area, int numberOfRooms, double pricePerSquareMeter, int numberOfOffices) {
        super(address, area, numberOfRooms, pricePerSquareMeter);
        this.numberOfOffices = numberOfOffices;
    }

    public void hostConference(String conferenceName) {
        System.out.println("В офисном здании проходит конференция: " + conferenceName);
    }

    @Override
    public String toString() {
        return super.toString() + ", офисов=" + numberOfOffices;
    }
}
