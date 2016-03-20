package U2.L3.ex5;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

    private static final long serialVersionUID = -4540950565015193926L;

    MyFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Warning! MyFrame");
        setFrameSize();
        add(new MyComponent());

    }

    private void setFrameSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 2, screenHeight / 2);
    }
}
