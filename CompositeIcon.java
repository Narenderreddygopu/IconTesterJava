import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class CompositeIcon implements Icon {
    private int width;
    private int height;
    private Color color;

    private List<Icon> icons;

    public CompositeIcon(Color color) {
        width = 0;
        height = 0;
        this.color = color;
        icons = new ArrayList<>();
    }

    public void addIcon(Icon icon) {
        icons.add(icon);
        this.width += icon.getIconWidth();
        this.height = Math.max(this.height, icon.getIconHeight());
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.draw(new Rectangle2D.Double(x, y,  width - 1, height - 1));

        for (Icon icon : icons) {
            icon.paintIcon(c, g, x, y);
            x += icon.getIconWidth() + 1;
        }        
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