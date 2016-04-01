package U2.L3.ex_layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергеева on 01.04.2016.
 * использовать последовательное расположение следует только в
 контейнере, где достаточно места, или там, где контейнеру некуда будет «прятать» свои компоненты
 */
public class FlowLayoutDemo extends JFrame {

    public FlowLayoutDemo() {
        super("FlowLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        //получаем панель содержимого
        Container c = getContentPane();
        //устанавливаем последовательное расположение c выравниванием компонента по центру
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        c.add(new JButton("Один"));
        c.add(new JButton("Два"));
        c.add(new JButton("Три"));
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}
