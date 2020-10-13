import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class App extends JFrame{
    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = { "MENU_PANEL", "CARD_3", "CARD_2" };

    public App() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        // On crée deux conteneurs de couleurs différentes
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.ORANGE);

        JButton bleu = new JButton("Vers le bleu");
        bleu.addActionListener(this::switchPanelBlue);
        JButton rouge = new JButton("Vers le rouge");
        rouge.addActionListener(this::switchPanelRed);

        menuPanel.add(bleu);
        menuPanel.add(rouge);

        JPanel card1 = new JPanel();
        card1.setBackground(Color.BLUE);

        JLabel titreCard1 = new JLabel("Panel bleu", SwingConstants.CENTER);
        JButton goToRed = new JButton("Panel rouge");
        goToRed.addActionListener(this::switchPanelRed);

        card1.setLayout(new GridLayout(2,1));
        card1.add(titreCard1);
        card1.add(goToRed);


        JPanel card2 = new JPanel();
        card2.setBackground(Color.RED);
        JLabel titreCard2 = new JLabel("Panel bleu", SwingConstants.CENTER);
        JButton goToBlue = new JButton("Panel bleu");
        goToBlue.addActionListener(this::switchPanelBlue);

        card2.setLayout(new GridLayout(2,1));
        card2.add(titreCard2);
        card2.add(goToBlue);

        JPanel panelPrincipal = new JPanel();
        JLabel titre = new JLabel("Switch entre deux panels");
        JButton retourMenu = new JButton("Retour au menu principal");
        retourMenu.addActionListener(this::retourMenuPrincipal);
        panelPrincipal.add(titre);
        panelPrincipal.add(retourMenu);

        // On définit le layout
        content.setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(menuPanel, listContent[0]);
        content.add(card1, listContent[1]);
        content.add(card2, listContent[2]);

        this.getContentPane().add(panelPrincipal, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);

    }

    private void retourMenuPrincipal(ActionEvent e) {
        cl.show(content, listContent[0]);
    }

    private void switchPanelBlue(ActionEvent e) {
        cl.show(content, listContent[1]);
    }

    private void switchPanelRed(ActionEvent e) {
        cl.show(content, listContent[2]);
    }


    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        App myWindow = new App();
        myWindow.setVisible(true);
    }

}
