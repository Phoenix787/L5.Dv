package ex2.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергеева on 10.03.2016.
 */
public class GameWindowTest extends JFrame {
    public void init(){
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout()); // стоит по умолчанию (разделяет область приложения на пять частей: север, юг, запад, восток, центр
        JButton jButton = new JButton("Hello");
        JButton jButton2 = new JButton("Bye");
        add(jButton, BorderLayout.CENTER);
        add(jButton2, BorderLayout.NORTH);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);
        add(new JButton("EAST"), BorderLayout.EAST);
        add(new JButton("WEST"), BorderLayout.WEST);


        setVisible(true);
    }
}
