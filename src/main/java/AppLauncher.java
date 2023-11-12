import javax.swing.*;
import java.text.MessageFormat;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreenGUI());
    }
}
