import java.awt.Color;

import javax.swing.JOptionPane;

public class IconTester {
    public static void main(String[] args) {
        CompositeIcon icon = new CompositeIcon(Color.GREEN);
        icon.addIcon(new CarIcon(100, Color.RED));
        icon.addIcon(new CoffeeMugIcon(100, 100, Color.BLUE));
        JOptionPane.showMessageDialog(
            null, 
            "Hello, Composite Icon",
            "Message",
            JOptionPane.INFORMATION_MESSAGE,
            icon);
    }
}
