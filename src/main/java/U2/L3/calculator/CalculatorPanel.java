package U2.L3.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 20.03.2016.
 */
public class CalculatorPanel extends JPanel {

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        //ввести область отображения результата
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertListener();
        ActionListener command = new CommandListener();

        //ввесьи кнопки сеткой 4x4
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);


    }

    private void addButton(String s, ActionListener insert) {
        JButton button = new JButton(s);
        button.addActionListener(insert);
        panel.add(button);
    }

    /**
     * при обработке событий строка действия кнопки вводится в конце отображаемого текста
     */

    private class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    /**
     * при обработке событий выполнятся команда указанная в строке действия кнопки
     */

    private class CommandListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else{
                    lastCommand = command;
                }
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * выполняет ожидающую калькуляцию
     * @param v Значение накапливаемое с учетом предыдущего результата
     */
    private void calculate(double v) {
         switch (lastCommand){
            case "+":
                result += v;
                break;
            case "-":
                result -= v;
                break;
            case "/":
                result /= v;
                break;
            case "*":
                result *= v;
                break;
        }

        display.setText("" + result);
    }
}

