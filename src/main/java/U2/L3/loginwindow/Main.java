package U2.L3.loginwindow;

import javax.swing.*;

/**
 * Created by Сергеева on 23.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
                    JFrame loginWindow = new LoginFrame();
                    loginWindow.setVisible(true);
        }
        );
    }
}
