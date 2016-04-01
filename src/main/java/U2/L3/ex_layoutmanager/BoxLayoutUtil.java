package U2.L3.ex_layoutmanager;

import javax.swing.*;

/**
 * Created by Сергеева on 01.04.2016.
 * можно не строить блочное расположение вручную, а воспользоваться статическими методами из
 * вспомогательного класса Box: createHorizontalBox(), createVerticalBox, которые возвращают экземпляр
 * класса Box
 */
public class BoxLayoutUtil {

    //возвращает панель с установленными вертикальным блочным размещением
    public static JPanel createVerticalPanel(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        return p;
    }

    //возвращает панель с установленным горизонатльным блочным расположением
    public static JPanel createHorizontalPanel(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        return p;
    }

}
