package UI;

import UI.plan_figures.RectangleDrawer;

import javax.swing.*;
import java.awt.*;

public class FactoryPlan extends JPanel {
    int bottomShift;
    RectangleDrawer rectangleDrawer;
    public FactoryPlan(int bottomShift) {
        super();
        this.bottomShift = bottomShift;
        System.out.println(getWidth());
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
        rectangleDrawer.drawRectangle(panelWidth / 20, panelHeight / 12, Color.BLACK, Color.BLACK, "Поставщик акссессуаров");
        rectangleDrawer.drawRectangle(panelWidth / 20, panelHeight / 3, Color.BLACK, Color.BLACK, "Поставщик двигателей");
        rectangleDrawer.drawRectangle(panelWidth / 20, (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Поставщик корпусов");
        rectangleDrawer.drawRectangle(panelWidth / 5, panelHeight / 12, Color.BLACK, Color.BLACK, "Склад акксессуаров");
        rectangleDrawer.drawRectangle(panelWidth / 5, panelHeight / 3, Color.BLACK, Color.BLACK, "Склад двигателей");
        rectangleDrawer.drawRectangle(panelWidth / 5, (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Склад корпусов");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.52), panelHeight / 3, Color.BLACK, Color.BLACK, "Сборка Машин");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.675), panelHeight / 12, Color.BLACK, Color.BLACK, "Контроллер склада");
        rectangleDrawer.drawRectangle((int) (panelWidth * 0.675), (int) (panelHeight * 0.6), Color.BLACK, Color.BLACK, "Поставщики машин");
    }

}
