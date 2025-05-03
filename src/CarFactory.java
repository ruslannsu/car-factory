import UI.UIController;
import UI.View;
import factory.Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CarFactory {
    UIController uiController;
    View view;
    Factory factory;
    Properties properties;
    public CarFactory() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        properties = new Properties();
        properties.load(new FileInputStream("src/source/config.properties"));
        view = new View(properties);
        factory = new Factory(view, properties);
        uiController = new UIController(factory, view);
    }
    void run() {

    }
}
