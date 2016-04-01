package U2.L3.ex_layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергеева on 01.04.2016.
 * Также никто не запрещает использовать распорки перед всей группой
 * компонентов или после нее, чтобы отодвинуть их от границ окна.
 * размер распорок задается в пикселах
 */
public class BoxStruts extends JFrame {
    public BoxStruts(){
        super("BoxStruts");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //панель с вертикальным блочным расположением
        Box p = Box.createVerticalBox();
//        JPanel p = BoxLayoutUtil.createVerticalPanel();
        p.add(new JButton("Один"));
        p.add(Box.createVerticalStrut(15));
        p.add(new JButton("Два"));
        p.add(Box.createVerticalStrut(5));
        p.add(new JButton("Три"));

        Box p2 = Box.createHorizontalBox();
//        JPanel p2 = BoxLayoutUtil.createVerticalPanel();
        p2.add(new JButton("One"));
        p2.add(Box.createHorizontalStrut(10));
        p2.add(new JButton("Two"));
        p2.add(Box.createHorizontalStrut(25));
        p2.add(new JButton("Three"));

        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(p2, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxStruts();
    }
}
