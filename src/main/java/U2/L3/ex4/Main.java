package U2.L3.ex4;

import U2.L3.ex3.view.LoginDialog;

import javax.swing.*;

/**
 * Created by Ксения on 19.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.pack();
                loginDialog.setVisible(true);
            }
        });

    }
}
