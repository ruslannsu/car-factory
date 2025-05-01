package factory.storage;

import factory.factory_product.FactoryProduct;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T extends FactoryProduct> {
    LinkedBlockingQueue<T> storage;
    Class<T> type;
    public Storage(Class<T> type, int storageSize) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        storage = new LinkedBlockingQueue<>(storageSize);
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
