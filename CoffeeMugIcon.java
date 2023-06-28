import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.Icon;

public class CoffeeMugIcon implements Icon {
    private int width;
    private int height;
    private Color color;

    public CoffeeMugIcon(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;

        int hw = (int) (width / 8);
        hw = Math.min(hw, 20);
        int hh = (int) (height / 4);
        hh = Math.min(hh, 40);


        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(1f));

        // top of the cofee cup
        g2d.draw(new Ellipse2D.Double(x, y, width-hw, height/4));

        // bottom of the coffee cup
        g2d.draw(new Ellipse2D.Double(x, y + height * 3 / 4, width - hw, height / 4));

        // left line joining the top and bottom ellipses
        g2d.draw(new Line2D.Double(x, y + height / 8, x, y + height * 7 / 8));

        // right line joining the top and bottom ellipses
        g2d.draw(new Line2D.Double(x + width - hw - 1, y + height / 8, x + width - hw - 1, y + height * 7 / 8));

        g2d.draw(new Ellipse2D.Double(x + width - hw - 1, y + height / 2 - hh / 2, hw, hh));
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
    
}
