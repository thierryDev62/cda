package templates;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JButton bleu = new JButton("Vers le bleu");
    private JButton rouge = new JButton("Vers le rouge");

    public MenuPanel() {
        this.setBackground(Color.ORANGE);
        this.add(bleu);
        this.add(rouge);
    }

    public JButton getBleu() {
        return bleu;
    }

    public JButton getRouge() {
        return rouge;
    }
}
