package factory.factory_product;

import factory.factory_product.components.*;

public class Car extends FactoryProduct {
    Motor motor;
    Body body;
    Accessory accessory;
    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }
    public void setBody(Body body) {
        this.body = body;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
