package factory.workers;

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
    public Workers(Storage<Body> bodyStorage,Storage<Accessory> accessoryStorage, Storage<Motor> motorStorage, int workersCount) {
        this.bodyStorage = bodyStorage;
        this.accessoryStorage = accessoryStorage;
        this.motorStorage = motorStorage;
        this.workersCount = workersCount;
        threadPool = new ThreadPool();
        for (int i = 0; i != workersCount; ++i) {
            threadPool.addThread(new Worker(threadPool.getTasks()));
        }
        threadPool.addTask(new Task());
        threadPool.addTask(new Task());
        threadPool.threadPoolRun();

    }





}
