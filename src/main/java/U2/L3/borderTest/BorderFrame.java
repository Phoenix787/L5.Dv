package U2.L3.borderTest;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 21.03.2016.
 */
public class BorderFrame extends JFrame {
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public BorderFrame() {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Titled", BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Titled Border"));
        addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Matte", BorderFactory.createMatteBorder(10,10,10,10,Color.GREEN));
        addRadioButton("SoftBorder", new SoftBevelBorder(1));
        addRadioButton("LineBorder", new LineBorder(Color.BLUE, 2, true));
        setLayout(new GridLayout(2,1));
        add(buttonPanel);
        add(demoPanel);
        pack();
    }

    private void addRadioButton(String name, final Border style) {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demoPanel.setBorder(style);
            }
        });
        group.add(button);
        buttonPanel.add(button);
    }
}
