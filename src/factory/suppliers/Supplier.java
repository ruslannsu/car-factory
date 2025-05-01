package factory.suppliers;

import factory.factory_product.components.Components;
import factory.storage.Storage;

public class Supplier<T extends Components> extends Thread {
    private Class<T> type;
    private Storage<T> storage;
    private int time;
    public Supplier(Class<T> type, Storage<T> storage, int time) {
        this.type = type;
        this.storage =  storage;
        this.time = time;
    }
    public void supply() {
        try {
            storage.getToStorage(type.getDeclaredConstructor().newInstance());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (isAlive()) {
            supply();
            try {
                sleep(time);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
