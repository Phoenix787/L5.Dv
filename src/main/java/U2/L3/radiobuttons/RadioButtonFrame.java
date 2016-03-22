package U2.L3.radiobuttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Сергеева on 21.03.2016.
 */
public class RadioButtonFrame extends JFrame {

    private static final long serialVersionUID = 718962410368515109L;

    private JPanel buttonPanel;
    private ButtonGroup buttonGroup;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    RadioButtonFrame(){
        label = new JLabel("This is sample text!");
        label.setFont(new Font("SanSerif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        Border border = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(border, "Radio button Group");
        buttonPanel.setBorder(titled);
        buttonGroup = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra Large", 36);

        add(buttonPanel, BorderLayout.SOUTH);

    }

    private void addRadioButton(String s, int i) {
        boolean selected = i == DEFAULT_SIZE;
        JRadioButton radioButton = new JRadioButton(s, selected);
        buttonGroup.add(radioButton);
        buttonPanel.add(radioButton);

//        ActionListener listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label.setFont(new Font("SanSerif", Font.PLAIN, i));
//            }
//        };

        //radioButton.addActionListener(listener);

        radioButton.addActionListener(
                (e)->label.setFont(new Font("SanSerif", Font.PLAIN, i))
        );
    }


}
