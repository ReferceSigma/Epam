package org.example.glava6;



import org.example.glava6.House;
import org.example.glava6.OfficeBuilding;
import org.example.glava6.ShoppingCenter;

public class Main {
    public static void main(String[] args) {

        House house = new House("ул. Зеленая, 15", 120.0, 4, 1500.0);
        house.build();
        house.expand(30.0);
        house.renovateRoom(2);
        house.rentOut();
        System.out.println(house);


        OfficeBuilding office = new OfficeBuilding("ул. Центральная, 45", 300.0, 10, 2000.0, 5);
        office.build();
        office.hostConference("Технологии 2024");
        System.out.println(office);

        ShoppingCenter mall = new ShoppingCenter("ул. Мира, 100", 500.0, 20, 2500.0, 15);
        mall.build();
        mall.hostEvent("Рождественская ярмарка");
        System.out.println(mall);
    }
}
