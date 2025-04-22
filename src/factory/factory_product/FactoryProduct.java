package factory.factory_product;

import java.lang.*;


public class FactoryProduct {
    int factoryProductID = System.identityHashCode(this);
    public int getID() {
        return factoryProductID;
    }
}
