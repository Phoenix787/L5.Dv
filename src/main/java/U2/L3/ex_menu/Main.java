package U2.L3.ex_menu;

import javax.swing.*;

/**
 * Created by Сергеева on 22.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuFrame frame = new MenuFrame();
                frame.setVisible(true);
            }
        });
    }
}
