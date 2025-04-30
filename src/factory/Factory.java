package factory;

import factory.controller.Controller;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;
import factory.workers.Workers;
import threadpool.ThreadPool;

public class Factory {
    private int workersCount;
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Workers workers;
    public Factory() {
        bodyStorage = new Storage<>();
        accessoryStorage = new Storage<>();
        motorStorage = new Storage<>();
        workersCount = 1;
        workers = new Workers(bodyStorage, accessoryStorage, motorStorage, workersCount);

    }
}
