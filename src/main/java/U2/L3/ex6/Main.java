package U2.L3.ex6;

import javax.swing.*;

/**
 * Created by Ксения on 20.03.2016.
 * hhhh
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                JFrame frame = new ImageFrame();
//                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
