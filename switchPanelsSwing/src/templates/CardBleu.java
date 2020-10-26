package templates;

import Controller.Datas;

import javax.swing.*;
import java.awt.*;

public class CardBleu extends JPanel {
    private final JLabel titreCard1 = new JLabel("Panel bleu", SwingConstants.CENTER);
    private final JButton goToRed = new JButton("GO Panel rouge");

    public CardBleu() {
        this.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(3,1));
        this.add(titreCard1);
        this.add(goToRed);

        Font font = new Font("Verdana", Font.BOLD, 15);
        JLabel text = new JLabel();
        text.setFont(font);

        text.setText("-->" + Datas.getDatas());

        this.add(text);
    }

    public JLabel getTitreCard1() {
        return titreCard1;
    }

    public JButton getGoToRed() {
        return goToRed;
    }
}
