package UI;

import UI.plan_figures.RectangleDrawer;

import javax.swing.*;
import java.awt.*;

public class FactoryPlan extends JPanel {
    int bottomShift;
    RectangleDrawer rectangleDrawer;
    int bodySuppliersStorageSize = 0;
    int motorSuppliersStorageSize = 0;
    int accessorySuppliersStorageSize = 0;
    int carStorageSize = 0;
    public FactoryPlan(int bottomShift) {
        super();
        this.bottomShift = bottomShift;
        System.out.println(getWidth());
    }
    public void updateSizes(int value, String source) {
        switch (source) {
            case "Car":
                carStorageSize = value;
                break;
            case "Accessory":
                accessorySuppliersStorageSize = value;
            case "Motor":
                motorSuppliersStorageSize = value;
            case "Body":
                bodySuppliersStorageSize = value;
        }
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        rectangleDrawer = new RectangleDrawer(graphics2D, 100, 100);
        ((Graphics2D) g).setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        ((Graphics2D) g).setColor(Color.BLUE);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        rectangleDrawer.drawRectangle(panelWidth / 20, panelHeight / 12, Color.BLACK, Color.BLACK, "Поставщик акссессуаров", "null");
        rectangleDrawer.drawRectangle(panelWidth / 20, panelHeight / 3, Color.BLACK, Color.BLACK, "Поставщик двигателей", "null");
        rectangleDrawer.drawRectangle(panelWidth / 20, (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Поставщик корпусов", "null");
        rectangleDrawer.drawRectangle(panelWidth / 5, panelHeight / 12, Color.BLACK, Color.BLACK, "Склад акксессуаров", String.valueOf(accessorySuppliersStorageSize));
        rectangleDrawer.drawRectangle(panelWidth / 5, panelHeight / 3, Color.BLACK, Color.BLACK, "Склад двигателей", String.valueOf(motorSuppliersStorageSize));
        rectangleDrawer.drawRectangle(panelWidth / 5, (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Склад корпусов", String.valueOf(bodySuppliersStorageSize));
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.45), panelHeight / 3, Color.BLACK, Color.BLACK, "Сборка Машин", "null");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.675), panelHeight / 12, Color.BLACK, Color.BLACK, "Контроллер склада", "null");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.675), (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Поставщики машин", "null");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.675), panelHeight / 3, Color.BLACK, Color.BLACK, "Склад машин", String.valueOf(carStorageSize));
    }

}
