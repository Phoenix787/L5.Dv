package U2.L3.ex6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ксения on 20.03.2016.
 * ++
 */
public class ImageComponent extends JPanel {
    private static final long serialVersionUID = 9212688498254072523L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("./img/wallet.png").getImage();
        g.drawImage(image, 10, 10, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}
