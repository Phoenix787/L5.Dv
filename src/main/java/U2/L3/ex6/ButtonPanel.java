package U2.L3.ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 20.03.2016.
 */
public class ButtonPanel extends JPanel implements ActionListener {

    public ButtonPanel(){
        setLayout(new FlowLayout());
        addGeneratedButton("Blue", Color.BLUE);
        addGeneratedButton("Red", Color.RED);
        addGeneratedButton("Green", Color.GREEN);
        addGeneratedButton("Pink", Color.PINK);
    }

    private void addGeneratedButton(String name, Color color) {
        JButton button = new JButton(name);
        button.setBackground(color);
        //button.setBorderPainted(false);
       // button.setOpaque(true);
        button.addActionListener(this);
        add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
