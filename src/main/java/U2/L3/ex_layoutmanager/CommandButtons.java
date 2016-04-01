package U2.L3.ex_layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергеева on 01.04.2016.
 * Табличное расположение придаст кнопкам одинаковый размер, а последовательное расположение не
 даст им «расплыться» и заодно выровняет их по правому краю.
 */
public class CommandButtons extends JFrame {
    public CommandButtons(){
        super("CommandButtons");
        setSize(350,350);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //создаем панель с табличным расположением компонентов для выравнивания кнопок
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        //добавляем компоненты на панель
        grid.add(new JButton("OK"));
        grid.add(new JButton("Cancel"));
        //помещаем полученное в панель с последовательным расположением компонентов с выравниванием
        //по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        getContentPane().add(flow, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CommandButtons();
    }
}
