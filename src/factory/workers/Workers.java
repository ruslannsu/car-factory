package factory.workers;

import factory.factory_product.Car;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;
import threadpool.Task;
import threadpool.ThreadPool;

public class Workers {
    ThreadPool threadPool;
    private int workersCount;
    Storage<Body> bodyStorage;
    Storage<Accessory> accessoryStorage;
    Storage<Motor> motorStorage;
    Storage<Car> carStorage;
    public Workers(Storage<Body> bodyStorage,Storage<Accessory> accessoryStorage, Storage<Motor> motorStorage, Storage<Car> carStorage,int workersCount) {
        this.bodyStorage = bodyStorage;
        this.accessoryStorage = accessoryStorage;
        this.motorStorage = motorStorage;
        this.workersCount = workersCount;
        this.carStorage = carStorage;
        threadPool = new ThreadPool();
        for (int i = 0; i != workersCount; ++i) {
            threadPool.addThread(new Worker(threadPool.getTasks()));
        }
    }
    public void run() {
        threadPool.addTask(new CreateCarTask(bodyStorage, accessoryStorage, motorStorage, carStorage));
        threadPool.threadPoolRun();
    }





}
