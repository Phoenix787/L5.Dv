package U2.L3.windowlistener;

import U2.L3.loginwindow.LoginFrame;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Сергеева on 24.03.2016.
 */
public class Main extends JPanel {

    public Main() {
        JButton btn1 = new JButton("Add...");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame();
                frame1.getContentPane().add(new Main());
                frame1.addWindowListener(new FrameListener1());
                frame1.setSize(200, 200);
                frame1.setVisible(true);

            }
        });
        add(btn1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Main());
        frame.addWindowListener(new FrameListener());
        frame.setSize(200, 200);
        frame.setVisible(true);

    }


    private static class FrameListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Window closing");

        }
    }
    private static class FrameListener1 extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Second Window closing");

        }
    }
}
