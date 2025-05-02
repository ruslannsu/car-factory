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
        rectangleDrawer.drawRectangle(10, 50, Color.BLACK, Color.BLACK, "Поставщик акссессуаров");
        rectangleDrawer.drawRectangle(10, 200, Color.BLACK, Color.BLACK, "Поставщик двигателей");
        rectangleDrawer.drawRectangle(10, 350, Color.BLACK, Color.BLACK, "Поставщик корпусов");
        rectangleDrawer.drawRectangle(200, 50, Color.BLACK, Color.BLACK, "Склад акксессуаров");
        rectangleDrawer.drawRectangle(200, 200, Color.BLACK, Color.BLACK, "Склад двигателей");
        rectangleDrawer.drawRectangle(200, 350, Color.BLACK, Color.BLACK, "Склад корпусов");
        rectangleDrawer.drawRectangle(520, 200, Color.BLACK, Color.BLACK, "Сборка Машин");
        rectangleDrawer.drawRectangle(675, 50, Color.BLACK, Color.BLACK, "Контроллер склада");
        rectangleDrawer.drawRectangle(675, 350, Color.BLACK, Color.BLACK, "Поставщики машин");




    }

}
