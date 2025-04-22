package factory.suppliers;

import factory.factory_product.components.Components;

public class Supplier<T extends Components> extends Thread {
    private Class<T> type;
    public Supplier(Class<T> type) {
        this.type = type;
    }
    public T supply() {
        try {
            return type.getDeclaredConstructor().newInstance();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public void run() {
        super.run();
    }
}
