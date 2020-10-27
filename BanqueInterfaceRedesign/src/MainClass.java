import fr.templates.App;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        App app = new App();
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setExtendedState(Frame.MAXIMIZED_BOTH);
        app.setLocationRelativeTo(null);
        app.pack();
        app.setVisible(true);
    }
}
