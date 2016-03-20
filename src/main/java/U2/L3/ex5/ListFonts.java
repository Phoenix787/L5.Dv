package U2.L3.ex5;

import java.awt.*;

/**
 * Created by Ксения on 20.03.2016.
 * выводит названия всех шрифтов в отдельной системе
 */
public class ListFonts {
    public static void main(String[] args) {
        String[] list = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String s : list) {
            System.out.println(s);
        }

        Font font = new Font("SansSerif", Font.BOLD, 14);

    }
}
