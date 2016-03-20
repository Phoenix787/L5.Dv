package U2.L3.ex5;

import javax.swing.*;

/**
 * Created by Ксения on 20.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MyFrame();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
