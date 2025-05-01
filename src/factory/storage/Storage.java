package factory.storage;

import factory.factory_product.FactoryProduct;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T extends FactoryProduct> {
    LinkedBlockingQueue<T> storage = new LinkedBlockingQueue<>(10);
    Class<T> type;
    public Storage(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.type = type;
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
    public void getToStorage(T carDetail) {
        try {
            storage.put(carDetail);
        }
        catch (Exception ex) {
            throw new RuntimeException();
        }
        System.out.println(storage.size());
        System.out.println(type);
    }

}
