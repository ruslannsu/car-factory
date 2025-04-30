package factory.workers;

import factory.factory_product.Car;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;
import threadpool.Task;

public class CreateCarTask extends Task {
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Storage<Car> storage;

    public CreateCarTask(Storage<Body> bodyStorage, Storage<Accessory> accessoryStorage, Storage<Motor> motorStorage) {
        super();
        this.bodyStorage = bodyStorage;
        this.accessoryStorage = accessoryStorage;
        this.motorStorage = motorStorage;
    }
    @Override
    public void execute() {

    }
}
