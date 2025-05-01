package factory.controller;

import factory.factory_product.Car;
import factory.storage.Storage;
import factory.workers.Workers;

public class Controller extends Thread {
    Storage<Car> carStorage;
    Workers workers;
    public Controller(Storage<Car> carStorage, Workers workers) {
        super();
        this.carStorage = carStorage;
        this.workers = workers;
    }
    @Override
    public void run() {
        int carStorageOldSize = carStorage.getStorageSize();
        while(isAlive()) {
            if (carStorageOldSize > carStorage.getStorageSize()) {
                workers.acceptTask();
            }
        }
    }
}
