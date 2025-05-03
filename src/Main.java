import UI.View;
import factory.Factory;
import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Components;
import factory.suppliers.Supplier;
import threadpool.ThreadPool;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        CarFactory carFactory = new CarFactory();
    }
}