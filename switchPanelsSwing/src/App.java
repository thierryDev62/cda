import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;

public class App extends JFrame{

    public App() {
        super("Switch entre deux panels");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        CardLayout cl = new CardLayout();
        JPanel mainView = new JPanel(cl);

        //mainView.add(new JPanel(), "empty");
        mainView.add(new Panel1());

        this.add(mainView);

        // Faire méthode avec bouton pour changer de panel

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Applys a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        App myWindow = new App();
        myWindow.setVisible(true);
    }
}
