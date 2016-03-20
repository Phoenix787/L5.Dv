package U2.L3.ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Created by К
 * сения on 20.03.2016.
 */
public class MyComponent extends JPanel {

    private static final long serialVersionUID = -270825975371194997L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("SansSerif", Font.BOLD, 14);
        String message = "Warning";
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        g2d.setFont(font);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(message, context);
        double stringWidth = bounds.getWidth();
        double stringHeight = bounds.getHeight();

        g2d.drawString(message, (int)(getHeight() - stringHeight) / 2, (int)(getWidth() - stringWidth) / 2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
