package U2.L3.textfield;

import javax.swing.*;

/**
 * Created by Ксения on 20.03.2016.
 * 789
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                    e.printStackTrace();
                }


                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                panel.add(new JTextField("Default Input", 10));
                panel.add(new JTextField(10));
                panel.add(new JButton("Ok"));

                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });

    }
}
