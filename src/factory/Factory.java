package factory;

import dealers.Dealer;
import dealers.Dealers;
import factory.controller.Controller;
import factory.factory_product.Car;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;
import factory.suppliers.Supplier;
import factory.suppliers.Suppliers;
import factory.workers.Workers;
import observer_subject.Observer;
import threadpool.ThreadPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Factory {
    Properties properties;
    Controller controller;
    Dealers dealers;
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Storage<Car> carStorage;
    Workers workers;
    Suppliers suppliers;
    public Factory(Observer observer) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        this.properties = new Properties();
        properties.load(new FileInputStream("src/source/config.properties"));
        bodyStorage = new Storage<>(Body.class, Integer.parseInt(properties.getProperty("bodyStorageSize")));
        bodyStorage.registerObserver(observer);
        accessoryStorage = new Storage<>(Accessory.class, Integer.parseInt(properties.getProperty("accessoryStorageSize")));
        accessoryStorage.registerObserver(observer);
        motorStorage = new Storage<>(Motor.class, Integer.parseInt(properties.getProperty("motorStorageSize")));
        motorStorage.registerObserver(observer);
        carStorage = new Storage<>(Car.class, Integer.parseInt(properties.getProperty("carStorageSize")));
        workers = new Workers(bodyStorage, accessoryStorage, motorStorage, carStorage, Integer.parseInt(properties.getProperty("workersCount")));
        carStorage.registerObserver(observer);
        int bodySupplierTime = Integer.parseInt(properties.getProperty("bodySupplierTime"));
        int motorSupplierTime = Integer.parseInt(properties.getProperty("motorSupplierTime"));
        int accessorySupplierTime = Integer.parseInt(properties.getProperty("accessorySupplierTime"));
        int bodySuppliersCount = Integer.parseInt(properties.getProperty("bodySupplierCount"));
        int motorSupplierCount = Integer.parseInt(properties.getProperty("motorSupplierCount"));
        int accessorySupplierCount = Integer.parseInt(properties.getProperty("accessorySupplierCount"));
        suppliers = new Suppliers(bodyStorage, accessoryStorage, motorStorage,
                                  bodySupplierTime, motorSupplierTime,
                                  accessorySupplierTime, bodySuppliersCount,
                                  accessorySupplierCount, motorSupplierCount);
        dealers = new Dealers(carStorage, Integer.parseInt(properties.getProperty("dealersCount")),
                              Integer.parseInt(properties.getProperty("dealersTime")));
        controller = new Controller(carStorage, workers);
        suppliers.runSuppliers();
        workers.runWorkers();
        controller.runController();
        dealers.runDealers();
    }
    public void updateDealersTime(int time) {
        dealers.updateTime(time);
    }
    public void  updateSuppliersTime(int time, String supplierName) {
        switch (supplierName) {
            case ("motorSupplier"):
                suppliers.updateMotorSuppliersTime(time);
                break;
            case ("accessorySupplier"):
                suppliers.updateAccessorySuppliersTime(time);
                break;
            case ("bodySupplier"):
                suppliers.updateBodySuppliersTime(time);
                break;
        }
    }
}
