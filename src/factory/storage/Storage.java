package factory.storage;

import factory.factory_product.FactoryProduct;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T extends FactoryProduct> {
    LinkedBlockingQueue<T> storage = new LinkedBlockingQueue<>();
    Class<T> type;
    public Storage(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.type = type;
        storage.offer(type.getDeclaredConstructor().newInstance());
        storage.offer(type.getDeclaredConstructor().newInstance());
        storage.offer(type.getDeclaredConstructor().newInstance());
        storage.offer(type.getDeclaredConstructor().newInstance());


    }
    public T getFromStorage() {
        try {
            return storage.take();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
