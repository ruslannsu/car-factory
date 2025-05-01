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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Factory {
    Properties properties;
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Storage<Car> carStorage;
    Workers workers;
    public Factory() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        bodyStorage = new Storage<>(Body.class);
        accessoryStorage = new Storage<>(Accessory.class);
        motorStorage = new Storage<>(Motor.class);
        this.properties = new Properties();
        properties.load(new FileInputStream("src/source/config.properties"));
        carStorage = new Storage<>(Car.class);
        workers = new Workers(bodyStorage, accessoryStorage, motorStorage, carStorage, Integer.parseInt(properties.getProperty("workersCount")));

    }
}
