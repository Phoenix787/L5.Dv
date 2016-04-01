package U2.L3.ex_layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергеева on 01.04.2016.
 * разделяет контейнер на таблицу с ячейками одинакового размера. Количество строк и столбцов можно
 * указать в конструкторе
 * Количество строк и столбцов можно указать в  конструкторе,
 * причем существует возможность задать произвольное количество либо строк,
 * либо столбцов (но не одновременно).
 * Все ячейки имеют одинаковый размер, равный размеру самого большого компонента,
 * находящегося в таблице.
 */
public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo(){
        super("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocation(100,100);
        //вспомогательная панель
        JPanel grid = new JPanel();
        //первые два параметра конструктора GridLayout - количество строк и столбцов в таблице
        // вторые два - расстояние между ячейками по X и Y
        GridLayout gl = new GridLayout(2, 0, 12, 12);
        grid.setLayout(gl);
        //создаем 8 кнопок
        for (int i = 0; i < 8; i++) {
            grid.add(new JButton("Кнопка " + i));
        }
        //помещаем нашу панель в центр окна
        getContentPane().add(grid);
        //устанавливаем оптимальный размер окна
        pack();
        //показываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }

}
