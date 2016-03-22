package U2.L3.ex_combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Сергеева on 22.03.2016.
 */
public class ComboBoxFrame extends JFrame {
    private JComboBox<String> comboBox;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame(){
        label = new JLabel("The quick brown fo jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        comboBox = new JComboBox<>();
        comboBox.addItem("Serif");
        comboBox.addItem("SansSerif");
        comboBox.addItem("Monospaced");
        comboBox.addItem("Dialog");
        comboBox.addItem("DialogInput");

        comboBox.addActionListener(e -> label.setFont(new Font(
                comboBox.getItemAt(comboBox.getSelectedIndex()),
                Font.PLAIN,
                DEFAULT_SIZE
        )));

        JPanel panel = new JPanel();
        panel.add(comboBox);
        add(comboBox, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }


}
