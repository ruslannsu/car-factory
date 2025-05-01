package factory.suppliers;

import factory.factory_product.components.Components;
import factory.storage.Storage;

public class Supplier<T extends Components> extends Thread {
    private Class<T> type;
    private Storage<T> storage;
    public Supplier(Class<T> type, Storage<T> storage) {
        this.type = type;
        this.storage =  storage;
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
        super.run();
    }
}
