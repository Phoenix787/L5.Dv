package U2.L3.ex4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ксения on 19.03.2016.
 */
public class LoginDialog extends JFrame {

    private static final long serialVersionUID = -7188927766878553470L;

    public LoginDialog() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFrameSize();
        setTitle("Login Dialog");
        setResizable(false);
        add(new MyComponent());

    }

    public void setFrameSize(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

    }


}
