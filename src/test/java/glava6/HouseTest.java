package glava6;
import org.example.glava6.House;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {

    @Test
    public void testCalculatePricePerSquareMeter() {
        House house = new House("ул. Зеленая, 15", 120.0, 4, 1500.0);
        double expectedPrice = 1500.0;
        assertEquals(expectedPrice, house.calculatePricePerSquareMeter(),
                "Цена за квадратный метр рассчитана неверно");
    }

    @Test
    public void testExpandArea() {
        House house = new House("ул. Зеленая, 15", 120.0, 4, 1500.0);
        house.expand(30.0);
        assertEquals(150.0, house.getArea(), "Площадь после расширения рассчитана неверно");
    }

    @Test
    public void testRenovateRoomValid() {
        House house = new House("ул. Зеленая, 15", 120.0, 4, 1500.0);
        house.renovateRoom(2);
    }



}
