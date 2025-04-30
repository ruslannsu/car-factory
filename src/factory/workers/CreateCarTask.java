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
    Storage<Car> carStorage;

    public CreateCarTask(Storage<Body> bodyStorage, Storage<Accessory> accessoryStorage, Storage<Motor> motorStorage, Storage<Car> carStorage) {
        super();
        this.bodyStorage = bodyStorage;
        this.accessoryStorage = accessoryStorage;
        this.motorStorage = motorStorage;
        this.carStorage = carStorage;
    }
    @Override
    public void execute() {
        Car car = new Car();
        car.setMotor(motorStorage.getFromStorage());
        car.setBody(bodyStorage.getFromStorage());
        car.setAccessory(accessoryStorage.getFromStorage());
        System.out.println("execute! car created");
    }
}
