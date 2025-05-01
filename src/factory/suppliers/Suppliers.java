package factory.suppliers;

import factory.factory_product.components.Accessory;
import factory.factory_product.components.Body;
import factory.factory_product.components.Motor;
import factory.storage.Storage;

import java.util.ArrayList;

public class Suppliers {
    ArrayList<Supplier<Body>> bodySuppliers;
    ArrayList<Supplier<Accessory>> accessorySuppliers;
    ArrayList<Supplier<Motor>> motorSuppliers;
    public Suppliers(Storage<Body> bodyStorage,Storage<Accessory> accessoryStorage, Storage<Motor> motorStorage, int bodySupplierTime,
                     int motorSupplierTime, int accessorySupplierTime, int bodySuppliersCount, int accessorySuppliersCount, int motorSuppliersCount) {
        bodySuppliers = new ArrayList<>();
        accessorySuppliers = new ArrayList<>();
        motorSuppliers = new ArrayList<>();
        for (int i = 0; i != bodySuppliersCount; ++i) {
            bodySuppliers.add(new Supplier<>(Body.class, bodyStorage, bodySupplierTime));
        }
        for (int i = 0; i != accessorySuppliersCount; ++i) {
            accessorySuppliers.add(new Supplier<>(Accessory.class, accessoryStorage, accessorySupplierTime));
        }
        for (int i = 0; i != motorSuppliersCount; ++i) {
            motorSuppliers.add(new Supplier<>(Motor.class, motorStorage, motorSupplierTime));
        }
    }
    public void runSuppliers()
    {
        for (Supplier<Body> bodySupplier : bodySuppliers){
            bodySupplier.start();
        }
        for (Supplier<Accessory> accessorySupplier : accessorySuppliers) {
            accessorySupplier.start();
        }
        for (Supplier<Motor> motorSupplier : motorSuppliers) {
            motorSupplier.start();
        }
    }

}
