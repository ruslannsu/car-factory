package UI.plan_figures;

import java.awt.*;

public class RectangleDrawer {
    Graphics2D graphics2D;
    int width;
    int height;
    public RectangleDrawer(Graphics g, int width, int height) {
        graphics2D = (Graphics2D)g;
        this.width = width;
        this.height = height;
    }
    public void drawRectangle(int x, int y, Color colorRect, Color colorText, String centerString, String size) {
        graphics2D.setColor(colorRect);
        Rectangle rect = new Rectangle(x, y, width, height);
        graphics2D.draw(rect);
        graphics2D.setColor(colorText);
        String[] lines = centerString.split(" ");
        graphics2D.drawString(lines[0], x + 10 , y + height / 2 );
        graphics2D.drawString(lines[1], x + 5, y + height / 2 + 10 );
        if (size != "null") {
            graphics2D.drawString(size, x + 20, y + height / 2 + 30);
        }
    }
}
