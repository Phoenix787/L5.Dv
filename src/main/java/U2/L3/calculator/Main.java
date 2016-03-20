package U2.L3.calculator;

import javax.swing.*;

/**
 * Created by Ксения on 20.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new CalculatorPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
