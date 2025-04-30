package factory;

import factory.controller.Controller;
import factory.factory_product.Car;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;
import factory.suppliers.Supplier;
import factory.workers.Workers;
import threadpool.ThreadPool;

public class Factory {
    private int workersCount;
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Storage<Car> carStorage;
    Workers workers;
    public Factory() {
        bodyStorage = new Storage<>(Body.class);
        accessoryStorage = new Storage<>(Accessory.class);
        motorStorage = new Storage<>(Motor.class);
        workersCount = 1;
        carStorage = new Storage<>(Car.class);
        workers = new Workers(bodyStorage, accessoryStorage, motorStorage, carStorage, workersCount);

    }
}
