import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginScreen {
    public static User handleUserLogin(ActionEvent e, String login, String password, JLabel warningLabel) {
        User loggedUser = SqLiteDatabaseManager.getUser(login, password);
        if (loggedUser == null) {
            // handle invalid input
            System.out.println("Invalid input");
            warningLabel.setVisible(true);
            return null;
        } else {
            // log the user in
            System.out.println(loggedUser.toString());
            warningLabel.setVisible(false);
            return loggedUser;
        }
    }
}
