package dealers;

import factory.factory_product.Car;
import factory.storage.Storage;

import java.util.ArrayList;

public class Dealer extends Thread {
    public int dealerTime;
    Storage<Car> carStorage;
    public Dealer(Storage<Car> carStorage, int dealerTime) {
        super();
        this.dealerTime = dealerTime;
        this.carStorage = carStorage;
    }

    @Override
    public void run() {
        while (isAlive()) {
            carStorage.getFromStorage();
            System.out.println(dealerTime);
            System.out.println("<- dealer time");
            try {
                sleep(dealerTime);
            }

            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
