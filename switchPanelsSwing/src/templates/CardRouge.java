package templates;

import javax.swing.*;
import java.awt.*;

public class CardRouge extends JPanel {
    private JLabel titreCard2 = new JLabel("Panel rouge", SwingConstants.CENTER);
    private JButton goToBlue = new JButton("GO Panel bleu");

    public CardRouge() {
        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(2,1));
        this.add(titreCard2);
        this.add(goToBlue);
    }

    public JLabel getTitreCard1() {
        return titreCard2;
    }

    public JButton getGoToBlue() {
        return goToBlue;
    }
}