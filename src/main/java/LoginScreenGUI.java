import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreenGUI extends JFrame {

    public LoginScreenGUI() {
        this.setTitle("Graid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.addComponents();
        this.setVisible(true);
    }
    private void addComponents() {

        JPanel loginScreenPanel = new JPanel(new GridBagLayout());

        JPanel headerPanel = new JPanel(new GridBagLayout());

        JLabel logoLabel = new JLabel(new ImageIcon(AppLauncher.class.getClassLoader().getResource("images/placeholder.png")));
        logoLabel.setPreferredSize(new Dimension(80, 80));
        JLabel greetingLabel = new JLabel("Hello there!");
        greetingLabel.setFont(new Font("Lato", Font.PLAIN, 22));

        headerPanel.add(logoLabel, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 0, 55)));
        headerPanel.add(greetingLabel, CustomLayoutManager.createGridBagConstraints(1, 0));


        JPanel loginPanel = new JPanel(new GridBagLayout());

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        JTextField loginText = new JTextField();
        loginText.setFont(new Font("Lato", Font.PLAIN, 22));
        loginText.setPreferredSize(new Dimension(350, 35));

        loginPanel.add(loginLabel, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 10, 0)));
        loginPanel.add(loginText, CustomLayoutManager.createGridBagConstraints(0, 1));


        JPanel passwordPanel = new JPanel(new GridBagLayout());

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        JPasswordField passwordText = new JPasswordField();
        passwordText.setFont(new Font("Lato", Font.PLAIN, 22));
        passwordText.setPreferredSize(new Dimension(350, 35));

        passwordPanel.add(passwordLabel, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 10, 0)));
        passwordPanel.add(passwordText, CustomLayoutManager.createGridBagConstraints(0, 1));

        JLabel warningLabel = new JLabel("Invalid login or password");
        warningLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        warningLabel.setForeground(Color.RED);
        warningLabel.setVisible(false);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());

        JButton forgotButton = new JButton("Forgot password?");
        forgotButton.setFont(new Font("Lato", Font.PLAIN, 16));
        forgotButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JButton loginButton = new JButton("Log in");
        loginButton.setFont(new Font("Lato", Font.PLAIN, 16));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Forgot password functionality
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User loggedUser = LoginScreen.handleUserLogin(e, loginText.getText(), new String(passwordText.getPassword()), warningLabel);
                if (loggedUser != null) {
                    LoginScreenGUI.this.dispose();
                    SwingUtilities.invokeLater(() -> new MainScreenGUI(loggedUser));
                }
            }
        });

        buttonsPanel.add(forgotButton, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 0, 50)));
        buttonsPanel.add(loginButton, CustomLayoutManager.createGridBagConstraints(1, 0, new Insets(0, 50, 0, 0)));

        loginScreenPanel.add(headerPanel, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 20, 0)));
        loginScreenPanel.add(loginPanel, CustomLayoutManager.createGridBagConstraints(0, 1, new Insets(0, 0, 10, 0)));
        loginScreenPanel.add(passwordPanel, CustomLayoutManager.createGridBagConstraints(0, 2, new Insets(0, 0, 10, 0)));
        loginScreenPanel.add(warningLabel, CustomLayoutManager.createGridBagConstraints(0, 3));
        loginScreenPanel.add(buttonsPanel, CustomLayoutManager.createGridBagConstraints(0, 4, new Insets(10, 0, 0, 0)));

        this.add(loginScreenPanel);
    }

}
