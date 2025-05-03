package UI;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Properties;

public class SlidersPanel extends JPanel {
    JSlider carDealerTime;
    JSlider motorSupplierTime;
    JSlider accessorySupplierTime;
    JSlider bodySupplierTime;
    public SlidersPanel(Properties properties) {
        super();
        properties.list(System.out);
        setBackground(Color.WHITE);
        int bodySupplierTimeConfig = Integer.parseInt(properties.getProperty("bodySupplierTime"));
        int motorSupplierTimeConfig = Integer.parseInt(properties.getProperty("motorSupplierTime"));
        int accessorySupplierTimeConfig = Integer.parseInt(properties.getProperty("accessorySupplierTime"));
        int carDealerTimeConfig = Integer.parseInt(properties.getProperty("dealersTime"));
        carDealerTime = new JSlider(0, 5000);
        carDealerTime.setName("dealerSlider");
        carDealerTime.setValue(carDealerTimeConfig);
        carDealerTime.setMajorTickSpacing(1000);
        carDealerTime.setPaintTicks(true);
        carDealerTime.setPaintLabels(true);
        motorSupplierTime = new JSlider(0, 5000);
        motorSupplierTime.setName("motorSlider");
        motorSupplierTime.setValue(motorSupplierTimeConfig);
        motorSupplierTime.setMajorTickSpacing(1000);
        motorSupplierTime.setPaintTicks(true);
        motorSupplierTime.setPaintLabels(true);
        accessorySupplierTime = new JSlider(0, 5000);
        accessorySupplierTime.setName("accessorySlider");
        accessorySupplierTime.setValue(accessorySupplierTimeConfig);
        accessorySupplierTime.setMajorTickSpacing(1000);
        accessorySupplierTime.setPaintTicks(true);
        accessorySupplierTime.setPaintLabels(true);
        bodySupplierTime = new JSlider(0, 5000);
        bodySupplierTime.setName("bodySlider");
        bodySupplierTime.setValue(bodySupplierTimeConfig);
        bodySupplierTime.setMajorTickSpacing(1000);
        bodySupplierTime.setPaintTicks(true);
        bodySupplierTime.setPaintLabels(true);
        carDealerTime.setBorder(BorderFactory.createTitledBorder("Поставка машин"));
        motorSupplierTime.setBorder(BorderFactory.createTitledBorder("Двигатели для машин"));
        bodySupplierTime.setBorder(BorderFactory.createTitledBorder("Корпусы для машин"));
        accessorySupplierTime.setBorder(BorderFactory.createTitledBorder("Акксессуары"));
        add(carDealerTime);
        add(motorSupplierTime);
        add(accessorySupplierTime);
        add(bodySupplierTime);
    }
    void initListener(ChangeListener changeListener) {
        motorSupplierTime.addChangeListener(changeListener);
        accessorySupplierTime.addChangeListener(changeListener);
        bodySupplierTime.addChangeListener(changeListener);
        carDealerTime.addChangeListener(changeListener);
    }
}
