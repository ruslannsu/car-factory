package factory.storage;

import factory.factory_product.FactoryProduct;
import observer_subject.Observer;
import observer_subject.Subject;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T extends FactoryProduct> implements Subject {
    Observer observer;
    LinkedBlockingQueue<T> storage;
    Class<T> type;
    public Storage(Class<T> type, int storageSize) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        storage = new LinkedBlockingQueue<>(storageSize);
        this.type = type;
    }
    public T getFromStorage() {
        try {
            this.notifyObservers();
            System.out.println(storage.size());
            return storage.take();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void sendToStorage(T carDetail) {
        try {
            this.notifyObservers();
            storage.put(carDetail);
        }
        catch (Exception ex) {
            throw new RuntimeException();
        }
    }
    public int getStorageSize() {
        return storage.size();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver() {
        this.observer = null;
    }
    @Override
    public void notifyObservers() {
        observer.update(storage.size(), type.getSimpleName());
    }


}
