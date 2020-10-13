package templates;

import javax.swing.*;
import java.awt.*;

public class CardBleu extends JPanel {
    private JLabel titreCard1 = new JLabel("Panel bleu", SwingConstants.CENTER);
    private JButton goToRed = new JButton("GO Panel rouge");

    public CardBleu() {
        this.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(2,1));
        this.add(titreCard1);
        this.add(goToRed);
    }

    public JLabel getTitreCard1() {
        return titreCard1;
    }

    public JButton getGoToRed() {
        return goToRed;
    }
}
