package UI;

import factory.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UIController {
    Factory factory;
    Properties properties;
    public UIController(Factory factory) throws IOException {
        properties = new Properties();
        this.factory = factory;
        properties.load(new FileInputStream("src/source/config.properties"));

    }
}
