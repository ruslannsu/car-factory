package factory.storage;

import factory.factory_product.FactoryProduct;

import java.util.ArrayList;

public class Storage<T extends FactoryProduct> {
    ArrayList<T> storage = new ArrayList<>();
    Class<T> type;
    public Storage(Class<T> type) {
        this.type = type;
    }
    public T getFromStorage() {
        try {

            if (storage.getLast() == null) {

            }
            return type.getDeclaredConstructor().newInstance();

        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
