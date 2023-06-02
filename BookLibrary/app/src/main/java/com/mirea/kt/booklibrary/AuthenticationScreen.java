package com.mirea.kt.booklibrary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AuthenticationScreen extends JFrame {
        private static final long serialVersionUID = 1L;
        private JPanel panel;
        private JLabel usernameLabel, passwordLabel;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;

        public AuthenticationScreen() {
            panel = new JPanel(new GridLayout(3, 2));
            usernameLabel = new JLabel("Введите логин:");
            passwordLabel = new JLabel("Введите пароль:");
            usernameField = new JTextField();
            passwordField = new JPasswordField();
            loginButton = new JButton("Войти");

            // Action Listener for Login Button Click Event
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    // Process the username and password data
                    // ...

                    // Hide the authentication screen and show the next screen
                    setVisible(false);
                    dispose();
                    new NextScreen().setVisible(true);
                }
            });

            // Add Components to Panel
            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);

            // Add Panel to Frame
            add(panel, BorderLayout.CENTER);

            // Frame Settings
            setTitle("Экран аутентификации");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }

        public static void main(String[] args) {
            AuthenticationScreen authenticationScreen = new AuthenticationScreen();
            authenticationScreen.setVisible(true);
        }
    }

}
