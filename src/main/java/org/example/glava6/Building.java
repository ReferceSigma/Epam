package org.example.glava6;

public interface Building {
    void build();
    double calculatePricePerSquareMeter();
    int getNumberOfRooms();
    void expand(double additionalArea);
}