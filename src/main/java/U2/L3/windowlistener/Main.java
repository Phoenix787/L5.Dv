package U2.L3.windowlistener;

import java.awt.*;

/**
 * Created by Сергеева on 24.03.2016.
 */
public class Main  {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm();
            }
        });


    }


}
