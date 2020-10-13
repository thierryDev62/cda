import templates.CardBleu;
import templates.CardRouge;
import templates.MenuPanel;
import templates.PanelPrincipal;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class App extends JFrame{
    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = { "MENU_PANEL", "CARD_1", "CARD_2" };

    public App() {
        super("Exemple de switch entre différents panels");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        // On crée trois conteneurs différents

        // Menu principal
        MenuPanel menu = new MenuPanel();
        menu.getBleu().addActionListener(this::switchPanelBlue);
        menu.getRouge().addActionListener(this::switchPanelRed);


        // Card bleue
        CardBleu card1 = new CardBleu();
        card1.getGoToRed().addActionListener(this::switchPanelRed);

        // Card rouge
        CardRouge card2 = new CardRouge();
        card2.getGoToBlue().addActionListener(this::switchPanelBlue);

        // Panel principal
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        panelPrincipal.getRetourMenu().addActionListener(this::retourMenuPrincipal);

        // On définit le layout
        content.setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(menu, listContent[0]);
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
