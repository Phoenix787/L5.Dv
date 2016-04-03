package U2.L3.ex_layoutmanager;

import javax.swing.*;

/**
 * Created by Сергеева on 01.04.2016.
 * С каждым компонентом ассоциируется особый информационный объект Spring,
 * который позволяет задать расстояние (в пикселах) между парой границ различных компонентов
 *
 * расстояние задается методом putConstraint()
 * В нем нужно указать границу компонента, сам компонент, расстояние,
 * а также границу второго компонента и сам второй компонент (это тот компонент,
 * что вы хотите отделить заданным расстоянием от первого компонента).
 * Первый вызов putConstraint() отделяет западную (левую) границу первой кнопки от западной же границы
 * контейнера. Второй вызов разделяет западную (левую) границу второй кнопки и восточную (правую)
 * границу первой кнопки пятью пикселами.
 *
 * менеджер SpringLayout предназначен прежде всего для автоматизированного построения интерфейса
 */
public class SpringLayoutDemo extends JFrame {
    private JButton button1;
    private JButton button2;

    public SpringLayoutDemo(){
        super("SpringLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //панель с использованием SpringLayout
        SpringLayout sl = new SpringLayout();
        JPanel contents = new JPanel(sl);

        contents.add(button1 = new JButton("Первая"));
        contents.add(button2 = new JButton("Последняя"));

        //настраиваеи распорки
        sl.putConstraint(SpringLayout.WEST, button1,5,SpringLayout.WEST, contents);
        sl.putConstraint(SpringLayout.WEST, button2,5,SpringLayout.EAST, button1);

        setContentPane(contents);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutDemo();
    }
}
