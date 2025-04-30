import factory.Factory;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Components;
import factory.suppliers.Supplier;
import threadpool.ThreadPool;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void printSomething() {
        System.out.println("thread check");
    }
    public static void main(String[] args) throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Factory factory = new Factory();

    }
}