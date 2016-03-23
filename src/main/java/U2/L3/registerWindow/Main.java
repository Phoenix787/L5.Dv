package U2.L3.registerWindow;

import javax.swing.*;

/**
 * Created by Сергеева on 23.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterFrame frame = new RegisterFrame();
                frame.setTitle("Register");
                frame.setSize(400, 200);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });

    }
}
