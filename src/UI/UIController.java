package UI;

import factory.Factory;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UIController {
    Factory factory;
    Properties properties;
    SliderListener sliderListener;
    View view;

    public UIController(Factory factory, View view) throws IOException {
        properties = new Properties();
        this.factory = factory;
        properties.load(new FileInputStream("src/source/config.properties"));
        sliderListener = new SliderListener(this);
        this.view = view;
        view.getSlidersPanel().initListener(sliderListener);
    }
    public void execute(String commandID, int param) {
        switch (commandID) {
            case "dealerSlider":
                factory.updateDealersTime(param);
                break;
            case "bodySlider":
                factory.updateSuppliersTime(param, "bodySupplier");
                break;
            case "accessorySlider":
                factory.updateSuppliersTime(param, "accessorySupplier");
                break;
            case "motorSlider":
                factory.updateSuppliersTime(param, "motorSupplier");
                break;
        }
    }
}
