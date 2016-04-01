package U2.L3.ex_layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 * Блочное расположение BoxLayout — прекрасная альтернатива всем остальным менеджерам
 * расположения. Обладая возможностями GridBagLayout, расположение BoxLayout не сложнее
 * BorderLayout. Менеджер блочного расположения выкладывает компоненты в контейнер блоками:
 столбиком (по оси Y) или полоской (по оси X), при этом каждый отдельный компонент можно
 выравнивать по центру, по левому или по правому краям, а также по верху или по низу.
 Расстояние между компонентами по умолчанию нулевое, но для его задания существуют специальные классы
 * конструктору BoxLayout необходимо указать контейнер в котором он будет функционировать
 */
public class Box1 extends JFrame {

    public Box1(){
        super("Box1 - Y");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //получаем панель содержимого
        Container c = getContentPane();

        //Устанавливаем блочное расположение по оси Y (столбиком)
        BoxLayout bl = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(bl);
        c.add(new JButton("Один"));
        c.add(new JButton("Два"));
        c.add(new JButton("Три"));

        setVisible(true);
    }

    static class Box2 extends JFrame{
        public Box2(){
            super("Box2 - X");
            setSize(400, 200);
            setLocation(100, 100);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            Container c = getContentPane();
            BoxLayout blx = new BoxLayout(c, BoxLayout.X_AXIS);
            c.setLayout(blx);
            c.add(new JButton("Один"));
            c.add(new JButton("Два"));
            c.add(new JButton("Три"));

            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Box1();
        new Box2();
    }

}
