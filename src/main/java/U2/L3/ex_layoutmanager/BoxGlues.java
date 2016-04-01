package U2.L3.ex_layoutmanager;

import javax.swing.*;

/**
 * Created by Сергеева on 01.04.2016.
 */
public class BoxGlues extends JFrame {
    public BoxGlues(){
        super("BoxGlues");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);

        //панель с вертикальным блочным расположением в ней разместим все остальные панели
        Box main = Box.createVerticalBox();
        //вертикальная панель
        Box pVert = Box.createVerticalBox();
        //заполнитель перед компонентами передвинет их вниз
        pVert.add(Box.createVerticalGlue());
        pVert.add(new JButton("One"));
        pVert.add(new JButton("Two"));

        Box pHoriz = Box.createHorizontalBox();
        pHoriz.add(Box.createHorizontalGlue());
        pHoriz.add(new JButton("One"));
        pHoriz.add(new JButton("Two"));
        pHoriz.add(Box.createHorizontalGlue());

        //укладываем панели вертикально
        main.add(pVert);
        main.add(Box.createVerticalStrut(15));
        main.add(pHoriz);

        getContentPane().add(main);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxGlues();
    }
}
