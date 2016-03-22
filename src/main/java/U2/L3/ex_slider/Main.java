package U2.L3.ex_slider;

import javax.swing.*;

/**
 * Created by Сергеева on 22.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            SliderFrame frame = new SliderFrame();
            frame.setVisible(true);
        });
    }
}
