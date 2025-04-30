import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Components;
import factory.suppliers.Supplier;
import threadpool.ThreadPool;

public class Main {
    public static void printSomething() {
        System.out.println("thread check");
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        threadPool.addThread();
        threadPool.addThread();
        threadPool.addTask();
        threadPool.addTask();
        threadPool.addTask();
        threadPool.threadPoolRun();
    }
}