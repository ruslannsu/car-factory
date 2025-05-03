package dealers;

import factory.factory_product.Car;
import factory.storage.Storage;

import java.util.ArrayList;

public class Dealers {
    int dealersTime;
    int dealersCount;
    Storage<Car> carStorage;
    ArrayList<Dealer> dealers;
    public Dealers(Storage<Car> storage, int dealersCount, int dealersTime) {
        this.carStorage = storage;
        dealers = new ArrayList<>();
        this.dealersCount = dealersCount;
        this.dealersTime = dealersTime;
        for (int i = 0; i != dealersCount; ++i) {
            dealers.add(new Dealer(carStorage, dealersTime));
        }
    }
    public void runDealers() {
        for (Dealer dealer : dealers) {
            dealer.start();
        }
    }

    public void updateTime(int time) {
        this.dealersTime = time;
        for (Dealer dealer : dealers) {
            dealer.dealerTime = time;
        }
    }
}
