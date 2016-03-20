package U2.L3.ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 20.03.2016.
 * draw image
 */
public class ImageFrame extends JFrame  implements ActionListener {
    private static final long serialVersionUID = -8527153834441017258L;

    public ImageFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Image Frame");
       // add(new ImageComponent());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        add(panel, "South");
        addGeneratedButton(panel, "Blue", Color.BLUE);
        addGeneratedButton(panel, "Red", Color.red);
        addGeneratedButton(panel, "Pink", Color.pink);
        addGeneratedButton(panel, "Green", Color.green);


    }

    private void addGeneratedButton(JPanel panel, String name, Color color) {
        JButton button = new JButton(name);
        button.setBackground(color);
        //button.setBorderPainted(false);
        // button.setOpaque(true);
        button.addActionListener(this);
        panel.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
