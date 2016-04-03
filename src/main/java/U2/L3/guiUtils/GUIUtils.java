package U2.L3.guiUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ксения on 01.04.2016.
 */
public class GUIUtils {

    public static void createRecommendedMargin(JButton[] buttons) {
        /**
         *  этот метод принимает массив ссылок на кнопки JButton и придает им нужный
         *  отступ слева и справа
         */
        for (int i = 0; i < buttons.length; i++) {
            //в объекте типа Insets хранится информация об отступах от текта до границы кнопки
            Insets margin = buttons[i].getMargin();
            margin.left = 12;
            margin.right = 12;
            buttons[i].setMargin(margin);
        }
    }
    // инструмент для придания группе компонентов одинаковых размеров (минимальных,
    // предпочтительных и максимальных).
    // Компоненты принимают размер самого большого (по ширине) компонента в группе
    public static void makeSameSize(JComponent[] components) {
        //получение ширины компонентов
        int[] sizes = new int[components.length];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = components[i].getPreferredSize().width;
        }
        //определение максимального размера
        int maxSizePos = maximumElementPos(sizes);
        Dimension maxSize = components[maxSizePos].getPreferredSize();

        //придание одинаковых размеров
        for(int i = 0; i < components.length; i++) {
            components[i].setPreferredSize(maxSize);
            components[i].setMaximumSize(maxSize);
            components[i].setMinimumSize(maxSize);
        }

    }

    public static void fixTextFieldSize(JTextField field){
        Dimension size = field.getPreferredSize();
        size.width = field.getMaximumSize().width;
        field.setMaximumSize(size);
    }

    private static int maximumElementPos(int[] sizes) {
        int maxPos = 0;
        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i] > sizes[maxPos]) maxPos = i;
        }
        return maxPos;
    }
}
