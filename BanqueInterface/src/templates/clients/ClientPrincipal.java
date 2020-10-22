package templates.clients;

import templates.principal.Init;
import templates.principal.PagePrincipale;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClientPrincipal extends JPanel {
    private BufferedImage fond = ImageIO.read(new File("images/espaceClientFond.jpg"));
    private JMenuItem mesInformations = new JMenuItem("Mes informations");
    private JMenuItem creerUnCompte = new JMenuItem("Créer un compte bancaire");
    private JMenuItem listeDesComptes = new JMenuItem("Liste des comptes");
    private JMenuItem consultationSolde = new JMenuItem("Consultation solde");
    private JMenuItem deconnexion = new JMenuItem("Déconnexion");
    private JMenuItem versement = new JMenuItem("Versement");
    private JMenuItem retrait = new JMenuItem("Retrait");
    private JMenuItem virement = new JMenuItem("Virement");
    private JMenuItem listeOperations = new JMenuItem("Liste des opérations");
    private JMenuItem totalVersement = new JMenuItem("Total des versements");
    private JMenuItem totalRetrait = new JMenuItem("Total des retraits");

    public ClientPrincipal() throws IOException {
        this.add(afficheTitreEtMenuBar());
    }
    private JPanel afficheTitreEtMenuBar() throws IOException {
        JPanel espaceClient = new JPanel();
        espaceClient.setLayout(new BorderLayout());
        espaceClient.add(titreEspaceClient(), BorderLayout.NORTH);
        espaceClient.add(afficheMenuBar(), BorderLayout.CENTER);
        espaceClient.add(imageDeFond(), BorderLayout.SOUTH);

        return espaceClient;
    }

    private JPanel titreEspaceClient() {

        JPanel conteneurTitre = new JPanel();
        conteneurTitre.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
        JLabel titre = new JLabel("Espace client");
        titre.setFont(new Init().getTitreFont());

        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel imageDeFond () {
        JPanel imageDeFond = new JPanel();
        JLabel imageFond = new JLabel(new ImageIcon(fond));
        imageDeFond.add(imageFond);

        return imageDeFond;
    }
    public JMenuBar afficheMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        /********** Menu "Mon compte" **********/
        JMenu monCompte = new JMenu("Mon compte");
        monCompte.setFont(new Init().getDefaultFont());

        mesInformations.setIcon(new ImageIcon("icones/man-coin-mini.png"));
        monCompte.add(mesInformations);

        monCompte.addSeparator();

        creerUnCompte.setIcon(new ImageIcon("icones/bank.png"));
        monCompte.add(creerUnCompte);

        listeDesComptes.setIcon(new ImageIcon("icones/contract-mini.png"));
        monCompte.add(listeDesComptes);

        consultationSolde.setIcon((new ImageIcon("icones/calculator-mini.png")));
        monCompte.add(consultationSolde);

        monCompte.addSeparator();

        deconnexion.setIcon(new ImageIcon("icones/exit.png"));
        monCompte.add(deconnexion);

        /********** Menu opérations **********/
        JMenu operations = new JMenu("Opérations");
        operations.setFont(new Init().getDefaultFont());

        versement.setIcon(new ImageIcon("icones/money-pig-mini.png"));
        operations.add(versement);

        retrait.setIcon(new ImageIcon("icones/burning-dollar-mini.png"));
        operations.add(retrait);

        virement.setIcon(new ImageIcon("icones/truck-mini.png"));
        operations.add(virement);

        /********** Menu consultations **********/
        JMenu consultations = new JMenu("Consultations");
        consultations.setFont(new Init().getDefaultFont());

        listeOperations.setIcon(new ImageIcon("icones/clipboard-graphs-mini.png"));
        consultations.add(listeOperations);

        totalVersement.setIcon(new ImageIcon("icones/gold-mini.png"));
        consultations.add(totalVersement);

        totalRetrait.setIcon(new ImageIcon("icones/target-mini.png"));
        consultations.add(totalRetrait);

        // Ajoute les onglets à la barre de menu
        menuBar.add(monCompte);
        menuBar.add(operations);
        menuBar.add(consultations);

        return menuBar;
    }

    public JMenuItem getMesInformations() {
        return mesInformations;
    }

    public JMenuItem getCreerUnCompte() {
        return creerUnCompte;
    }

    public JMenuItem getListeDesComptes() {
        return listeDesComptes;
    }

    public JMenuItem getDeconnexion() {
        return deconnexion;
    }

    public JMenuItem getConsultationSolde() {
        return consultationSolde;
    }

    public JMenuItem getVersement() {
        return versement;
    }

    public JMenuItem getRetrait() {
        return retrait;
    }

    public JMenuItem getVirement() {
        return virement;
    }

    public JMenuItem getListeOperations() {
        return listeOperations;
    }

    public JMenuItem getTotalVersement() {
        return totalVersement;
    }

    public JMenuItem getTotalRetrait() {
        return totalRetrait;
    }
}
