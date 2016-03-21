package U2.L3.radiobuttons;

import javax.swing.*;

/**
 * Created by Сергеева on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RadioButtonFrame frame = new RadioButtonFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
