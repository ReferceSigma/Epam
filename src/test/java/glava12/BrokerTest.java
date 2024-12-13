package glava12;



import org.example.glava12.Broker;
import org.example.glava12.Market;
import org.example.glava12.Stock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrokerTest {

    @Test
    void testBrokerPerformsTrade() {
        Stock stock = new Stock("TestCompany", 100);
        Market market = new Market(List.of(stock));
        Broker broker = new Broker("Broker1", market);

        Thread brokerThread = new Thread(broker);
        brokerThread.start();

        try {
            Thread.sleep(500); // Дать время брокеру выполнить сделки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        market.stopTrading();
        double updatedPrice = stock.getPrice();
        assertTrue(updatedPrice != 100, "Брокер должен выполнять сделки, изменяя цену акций.");
    }
}

