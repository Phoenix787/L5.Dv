package U2.L3.loginwindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Сергеева on 23.03.2016.
 */
public class LoginFrame extends JFrame {

    JTextField tfUsername;
    JPasswordField pfPassword;
    JLabel lbRegister;
    JLabel lbUsername;
    JLabel lbPassword;

    JButton btnLogin;
    JButton btnCancel;
    private boolean succeeded;


    LoginFrame(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new LineBorder(Color.gray));
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);

        lbRegister = new JLabel("Register", JLabel.RIGHT);
        lbRegister.setFont(new Font(Font.SANS_SERIF, FontUIResource.BOLD, 12));
        lbRegister.setForeground(Color.blue);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(lbRegister, cs);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (LoginController.authenticate(getUserName(), getPassword())){
                    JOptionPane.showMessageDialog(LoginFrame.this, "Hi " + getUserName() + "!\nYou have " +
                            "successfully logged in.", "Login", JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    // TODO: 23.03.2016 сделать чтобы форма открывалась посередине рабочего стола
                    // TODO: 23.03.2016  сделать открытие главного окна финансового менеджера
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Login",
                            JOptionPane.ERROR_MESSAGE);
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;

                }

            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnLogin);
        btnPanel.add(btnCancel);


        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
        setResizable(false);
        pack();






    }

    private String getPassword() {
        return new String(pfPassword.getPassword());
    }

    private String getUserName() {
        return tfUsername.getText();
    }

}
